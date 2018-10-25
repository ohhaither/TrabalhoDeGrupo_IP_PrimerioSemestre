public class Sudoku1
{
  static int num, d, soma = 0, multiplicacao = 1; // variáveis usadas por múltiplas funções

  public static int verificacao(int num, int d)
  {
    // recolha de dados
    // --------------------------------------------------------------------------------------------------------
    int n = num, tamanhoNum = 0, maior = 0, menor = d;
    while (n > 0)
    {
      int digito = n % 10; // último dígito de n
      n /= 10; // n perde o seu último dígito
      tamanhoNum++; // tamanho de num
      if (digito > maior) // Se o algarismo das unidades for maior que o maior atual...
          maior = digito; // ... o maior passa a ser a atual unidade
      if (digito < menor) // Se o algarismo das unidades for menor que o menor atual...
          menor = digito; // ... o menor passa a ser a atual unidade
    }
    // --------------------------------------------------------------------------------------------------------
    
    // Condição 1
    // --------------------------------------------------------------------------------------------------------
    boolean out1 = false; // valor de saída para a função 1: true se a condição 2 for verdadeira, falsa se não
    if (num > 0) // num é positivo?
    {
      out1 = tamanhoNum == d? true:false; // num tem d dígitos?
    }
    // --------------------------------------------------------------------------------------------------------
    
    // Condição 2
    // --------------------------------------------------------------------------------------------------------
    boolean menorEum = menor == 1? true:false; // o menor digito é 1?
    boolean maiorEd = maior == d? true:false; // o maior dígito é d?
    boolean out2; // valor de saída para a condição 2
    if (menorEum == true && maiorEd == true)
      out2 = true;
    else  
      out2 = false;
    // --------------------------------------------------------------------------------------------------------
    
    //Condição 3
    // --------------------------------------------------------------------------------------------------------
    // soma e multiplicação
    n = num;
    int digito, soma_ = 0, multiplicacao_ = 1;
    for (int i = 1; i <= d; i++)
    {
      soma += i;
      multiplicacao *= i;
      digito = n % 10;
      n /= 10;
      soma_ += digito;
      multiplicacao_ *= digito;
    }
    boolean somaIgual = soma == soma_? true:false;
    boolean multIgual = multiplicacao == multiplicacao_? true:false;
    boolean out3 = somaIgual == true && multIgual == true? true:false;
    // --------------------------------------------------------------------------------------------------------
    
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
        mensagem = String.format("valor negado...\n%d não é positivo ou não tem %d dígitos",num, d);
        break;
      case 2:
        mensagem = String.format("valor negado...\no menor dígito de %d não é 1 ou o maior não é %d", num, d);
        break;
      case 3:
        mensagem = String.format("valor negado...\na soma dos dígitos de %d não é %d ou o seu produto não é %d", num, soma, multiplicacao);
        break;
      default:
        mensagem = "valor negado";
      }
    System.out.println(val); // Temporária: para deteção de erros
    System.out.println(mensagem);
  }


  public static void main(String[] arg)
  {
    /* Não executar o método verificação mais de que uma vez de forma a evitar que as variáveis soma
    e multiplicação assumam valores errados */ 
    num = 12345;
    d = 5;
    analise(verificacao(num, d));
  }

}
