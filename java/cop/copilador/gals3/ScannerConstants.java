package br.com.ahe.cop.copilador.gals3;

public interface ScannerConstants
{

	int[] TOKEN_STATE = {-2,  0, -1, -1,  0, 29, 30, 33, 31, 24, 32, 34,  7, 25, 26, 38, 36, 40, 27, 28,  2,  2,  2,  2,  2, 37,  9, -2, -1, 35, 39, 41, -1, -1, -1, -1, -1, -2,  8,  2,  6,  4,  3,  5,  0 };

	int[] SPECIAL_CASES_INDEXES =
		{ 0, 0, 0, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14, 14 };

	String[] SPECIAL_CASES_KEYS =
		{  "and", "false", "if", "in", "isFalseDo", "isTrueDo", "main", "module", "not", "or", "out", "return", "true", "while" };

	int[] SPECIAL_CASES_VALUES =
		{  10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23 };

	String[] SCANNER_ERROR =
		{
			"Caractere n�o esperado",
			"",
			"Erro identificando \"!=\"",
			"Erro identificando constante string",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"Erro identificando comet�rio de linha",
			"Erro identificando constante de float",
			"",
			"",
			"",
			"Erro identificando palavra_reservada",
			"Erro identificando identificador de boolean",
			"Erro identificando identificador de float",
			"Erro identificando identificador de int",
			"Erro identificando identificador de string",
			"Erro identificando comentario de bloco",
			"",
			"",
			"",
			"",
			"",
			"",
			""
		};

}
