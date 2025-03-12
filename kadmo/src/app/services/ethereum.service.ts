import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ethers } from 'ethers';
import { Observable } from 'rxjs';

declare let window: any;

@Injectable({
  providedIn: 'root',
})
export class EthereumService {
  // private apiUrl = 'http://localhost:5000/send-transaction'; // Ajusta la URL si cambia

  // constructor(private http: HttpClient) {}

  // sendPayment(to: string, amount: number): Observable<any> {
  //   return this.http.post<any>(this.apiUrl, { to, amount });
  // }
  provider!: ethers.BrowserProvider;
  signer: ethers.Signer | null = null;

  constructor() {
    if (window.ethereum) {
      this.provider = new ethers.BrowserProvider(window.ethereum);
    } else {
      console.error('MetaMask no está instalado');
    }
  }

  async connectWallet() {
    try {
      if (!window.ethereum) throw new Error('MetaMask no está disponible');

      await window.ethereum.request({ method: 'eth_requestAccounts' });

      this.provider = new ethers.BrowserProvider(window.ethereum);
      this.signer = await this.provider.getSigner();

      console.log('Cuenta conectada:', await this.signer.getAddress());
    } catch (error) {
      console.error('Error conectando MetaMask:', error);
    }
  }

  async sendPayment(to: string, amount: number) {
    try {
      if (!this.signer) throw new Error('No hay signer disponible');

      console.log('Enviando transacción a:', to, 'con monto:', amount);

      const tx = await this.signer.sendTransaction({
        to,
        value: ethers.parseEther(amount.toString()),
      });

      console.log('Transacción enviada:', tx.hash);
      return tx.hash;
    } catch (error) {
      console.error('Error al enviar la transacción:', error);
      throw error;
    }
  }
}
