public class Sudoku1
{
  static int num, d;
  public static int verificacao(int num, int d)
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
    
    //Condição 3
    //-------------------------------------------------------------
    n = num;
    
    // soma e multiplicação
    int soma = 0;
    int mult = 0;
    for (int i = 1; i <= d; i++) // necessário
    {
      soma += i;
      mult *= i;
    }
    
    int unidade;
    int soma_ = 0;
    for (int i = 0; i < d; i++) // Converger
    {
      unidade = n % 10;
      n /= 10;
      soma_ += unidade;
    }
    boolean somaIgual = soma == soma_? true:false;
    
    int mult_ = 0;
    for (int i = 0; i < d; i++) // Converger
    {
      unidade = n % 10;
      n /= 10;
      mult_ *= unidade;
    }
    boolean multIgual = mult == mult_? true:false;
    
    boolean out3 = somaIgual == true && multIgual == true? true:false;
    //-------------------------------------------------------------
    
    
    // Retorno
    int output;
    if (out1 == true && out2 == true && out3 == true)
      output = 0;
    else 
    {
      if ((out1 == false && out2 == false && out3 == false) || 
	        (out1 == false && out2 == false) || (out1 == false && out3 == false) )
        output = 1;
      else if ((out2 == false) || (out2 == false && out3 == false))
        output = 2;
      
      else // Se a condição 3 for a única falsa
        output = 3;
    }
    return output;
  }    


  public static void analise(int val)
  {
    String mensagem;
    switch(val)
    {
      case 0:
        mensagem = "valor aceite";
        break;
      case 1:
        mensagem = String.format("valor negado...\no valor digitado não é positivo ou não tem %d dígitos", d);
        break;
      case 2:
        mensagem = String.format("valor negado...\no menor dígito de %d não é '1' ou o maior não é %d", num, d);
        break;
      case 3:
        mensagem = String.format("valor negado...\na soma dos dígitos de %d não é igual a 1+2+...+%d ou o seu produto não é igual a 1x2x...x%d", num, d, d);
        break;
      default:
        mensagem = "valor negado";
    }
    System.out.println(mensagem);
  }


  public static void main(String[] arg)
  {
    num = 5341;
    d = 5;
    analise(verificacao(num, d));
    System.out.println(verificacao(num, d));
  }

}
