import 'dotenv/config';
import { drizzle } from "drizzle-orm/mysql2";
import mysql from "mysql2/promise";

const connection = mysql.createPool({
  host: process.env.DB_HOST || "reportcity.ddns.net",
  port: Number(process.env.DB_PORT) || 3306,
  user: process.env.DB_USER || "ReportCity",
  password: process.env.DB_PASSWORD || "H7dIkM4du9(l4I27",
  database: process.env.DB_NAME || "ReportCity",
  waitForConnections: true,
  connectionLimit: 10,
  queueLimit: 0
});

export const db = drizzle(connection, {
  logger: process.env.NODE_ENV === "development",
  mode: "default"
});

// Exportar o tipo da conexão para uso em transações
export type MySqlConnection = typeof connection;