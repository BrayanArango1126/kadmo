import { ethers } from "ethers";

// Conectar con Ganache (Asegúrate de que está corriendo)
const provider = new ethers.JsonRpcProvider("http://127.0.0.1:7545");

// Cuenta generada por Ganache (copia una clave privada desde la app de Ganache)
const privateKey =
  "0x7041e52e14c1141c904ab9371ec4a702acbfe055caf9cabb0089ded872f3260b";
const wallet = new ethers.Wallet(privateKey, provider);

const main = async () => {
  console.log("Conectado a:", await provider.getNetwork());
  console.log("Dirección de la cuenta:", wallet.address);

  // Consultar balance
  const balance = await provider.getBalance(wallet.address);
  console.log("Balance:", ethers.formatEther(balance), "ETH");
};

main().catch(console.error);

const sendTransaction = async () => {
  const receiver = "0x983eb2EeF77d44933914e714eC233Eed69e36A1F"; // Cambia esto por otra cuenta de Ganache
  const amount = ethers.parseEther("0.1"); // 0.1 ETH

  console.log(`Enviando ${ethers.formatEther(amount)} ETH a ${receiver}...`);

  const tx = await wallet.sendTransaction({
    to: receiver,
    value: amount,
  });

  console.log("Transacción enviada:", tx.hash);
  await tx.wait();
  console.log("Transacción confirmada");
};

await sendTransaction();
