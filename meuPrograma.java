import java.util.Scanner;
public class meuPrograma{ 
   public static void main(String args[]){ 
   Scanner _scTrx = new Scanner(System.in);
	double a;
	double b;
	String c;
	String x;
c = _scTrx.nextLine();
System.out.println("Hello World");
System.out.println("Fim do programa");
x="Hello World";
a = _scTrx.nextDouble();
System.out.println(a);
b = _scTrx.nextDouble();
System.out.println(x);
if (a>5) {System.out.println("maior que 5");
a=a+1;
}else {System.out.println("menor que 5");
}a=a+1;
while (a<b) {
System.out.println("a menor que b");
a=a+1/2*4;
}a=0;
do {
a=a+2;
System.out.println("esta funcionando o dowhile");
System.out.println("testando if aninhado ao dowhile");
if (b>=0) {System.out.println("b positivo");
}else {System.out.println("b negativo");
}}while (a<b);   }
}
