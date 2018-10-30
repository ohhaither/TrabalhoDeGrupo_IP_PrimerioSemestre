public class Sudoku
{

    public static void main(String[] args)
    {
	Verificacao(123456789, 9);
	Verificacao(12345679, 9);
	Verificacao(1234567893, 9);
	Verificacao(234567892, 9);
	Verificacao(123456785, 9);
	Verificacao(123447789, 9);
    }

    public static int Verificacao(int num, int d)
    {
	// ------------------------------------------------------------
	// Condição 1
	// ------------------------------------------------------------

	    int n = num, contador = 0;
	    while (n > 0)
	    {
		n /= 10;
		contador++;
	    }
	    if (contador != d )
	    {
		System.out.println("o numero " + num + " nao verifica a condicao \"positivo e tem " + 9 + " digitos\".");
		return 1;
	    }
	// ------------------------------------------------------------
	// Condição 2
	// ------------------------------------------------------------

	int maior = 0, menor = d;
	n = num;
	while (n > 0)
	{
	    int unidade = n % 10; // algarismo das unidades de n
	    n /= 10; // n perde o seu atual algarismo das unidades

	    if (unidade > maior) // Se o algarismo das unidades for maior que o maior atual...
		maior = unidade;// ... o maior passa a ser a atual unidade

	    if (unidade < menor) // Se o algarismo das unidades for menor que o menor atual...
		menor = unidade; // ... o menor passa a ser a atual unidade
	}

	if (maior != d || menor != 1)
	{
	    System.out.println( "O numero " + num + " nao verifica a condicao \"maior digito " + d + " e menor digito 1\".");
	    return 2;
	}
	// ------------------------------------------------------------
	// Condição 3
	// -------------------------------------------------------------
	n = num;

	int soma = 0;
	int mult = 1;
	for (int i = 1; i <= d; i++)
	{
	    soma += i;
	    mult *= i;
	}

	int soma_ = 0;
	int mult_ = 1;
	for (int i = 0; i < d; i++)
	{
	    soma_ += n % 10;
	    mult_ *= n % 10;
	    n /= 10;
	}

	if (mult != mult_ || soma != soma_)
	{
	    System.out.println("O numero " + num + " nao verifica a condicao \"soma digitos " + soma + " e produto digitos " + mult + "\".");
	    return 3;
	}

	System.out.println("O numero " + num + " passou todas as condicoes verificadas.");
	return 0;
    }
}
