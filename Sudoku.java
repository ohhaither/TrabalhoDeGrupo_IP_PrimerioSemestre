public class Sudoku
{
  /* 
  Duas condições já foram resolvidas sendo que o método atualmente retorna 0 se forem todas verdadeiras
  e 1 se alguma for falsa
  */

  public static int Verificacao(int num, int d)
  {
    // Condição 1
    //------------------------------------------------------------
    boolean out1 = false; // valor de saída para a função 1: true se a condição 2 for verdadeira, falsa se não
    if (num > 0) // num é positivo?
    {
      // num tem d dígitos?
      int n = num, contador = 0;
      while (n > 0)
      {
        n /= 10;
        contador++;
      }
      out1 = contador == d? true:false;
    }
    //------------------------------------------------------------
    

    // Condição 2
    //------------------------------------------------------------
    int maior = 0, menor = 9, n = num;
    while (n > 0)
    {
      int unidade = n % 10; // algarismo das unidades de n
      n /= 10; // n perde o seu atual algarismo das unidades

      if (unidade > maior) // Se o algarismo das unidades for maior que o maior atual...
          maior = unidade;// ... o maior passa a ser a atual unidade
      
      if (unidade < menor) // Se o algarismo das unidades for menor que o menor atual...
          menor = unidade; // ... o menor passa a ser a atual unidade
    }
        
    boolean menorEum = menor == 1? true:false; // o menor digito é 1?
    boolean maiorEd = maior == d? true:false; // o maior dígito é d?
    boolean out2; // valor de saída para a condição 2
    if (menorEum == true && maiorEd == true)
      out2 = true;
    else
      out2 = false;
    //------------------------------------------------------------



    // Retorno do método
    if (out1 == true && out2 == true)
      return 0;
    else
      return 1;
  }

  public static void main(String[] args)
  {
    System.out.println(Verificacao(123456789, 9));
  }
}
