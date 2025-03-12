import express from "express";
import dotenv from "dotenv";
import { ethers } from "ethers";
import cors from "cors";

dotenv.config();
const app = express();
app.use(express.json());

// Permitir CORS solo desde Angular (ajusta la URL según tu configuración)
app.use(
  cors({
    origin: "http://localhost:4200", // Reemplázalo con el dominio de tu frontend en producción
    methods: "POST",
    allowedHeaders: "Content-Type",
  })
);

// Configurar la conexión con la blockchain
const provider = new ethers.JsonRpcProvider(process.env.INFURA_URL);
const wallet = new ethers.Wallet(process.env.PRIVATE_KEY, provider);

// Endpoint para recibir pagos
app.post("/send-transaction", async (req, res) => {
  try {
    const { to, amount } = req.body;

    if (!to || !amount) {
      return res.status(400).json({ success: false, error: "Faltan datos" });
    }

    const tx = await wallet.sendTransaction({
      to,
      value: ethers.parseEther(amount.toString()),
    });

    console.log("Transacción enviada:", tx.hash);
    res.json({ success: true, hash: tx.hash });
  } catch (error) {
    console.error("Error en la transacción:", error);
    res.status(500).json({ success: false, error: error.message });
  }
});

// Iniciar el servidor
const PORT = process.env.PORT || 5000;
app.listen(PORT, () => console.log(`Servidor corriendo en el puerto ${PORT}`));
