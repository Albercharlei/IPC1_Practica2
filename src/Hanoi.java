import java.util.Stack;
import java.util.Scanner;

class Columnas {
	
	static int x;
	static Stack<Integer> torre1 = new Stack<Integer>();
	static Stack<Integer> torre2 = new Stack<Integer>();
	static Stack<Integer> torre3 = new Stack<Integer>();
	
	public static void apilarTorre(int x){
	
		torre1.push(100);
		torre2.push(100);
		torre3.push(100);
		
		if(x<=8){
			for(int i=0;i<x;i++){
			torre1.push(x-i);
			}
		}
		else{System.out.println("El m‡ximo es 8");}
	}
}

class Verificar {
	
	static int a;
	static int b;
	static int contador=0;
	
	public static void verificar(int a,int b) {
		
		if(a==1&&b==2){
			if(Columnas.torre1.peek()>=Columnas.torre2.peek()){
				System.out.println("Movimiento no permitido");
			}
			else{
				contador++;
				Mover.mover(a, b);
			}
		}
		
		if(a==1&&b==3){
			if(Columnas.torre1.peek()>=Columnas.torre3.peek()){
				System.out.println("Movimiento no permitido");
			}
			else{
				contador++;
				Mover.mover(a, b);
			}
		}
		
		if(a==2&&b==1){
			if(Columnas.torre2.peek()>=Columnas.torre1.peek()){
				System.out.println("Movimiento no permitido");
			}
			else{
				contador++;
				Mover.mover(a, b);
			}
		}
		
		if(a==2&&b==3){
			if(Columnas.torre2.peek()>=Columnas.torre3.peek()){
				System.out.println("Movimiento no permitido");
			}
			else{
				contador++;
				Mover.mover(a, b);
			}
		}
		
		if(a==3&&b==1){
			if(Columnas.torre3.peek()>=Columnas.torre1.peek()){
				System.out.println("Movimiento no permitido");
			}
			else{
				contador++;
				Mover.mover(a, b);
			}
		}
		
		if(a==3&&b==2){
			if(Columnas.torre3.peek()>=Columnas.torre2.peek()){
				System.out.println("Movimiento no permitido");
			}
			else{
				contador++;
				Mover.mover(a, b);
			}
		}
	}
}

class Mover {
	
	public static void mover(int a, int b){
		
		if(a==1&&b==2){
			Columnas.torre2.push(Columnas.torre1.peek());
			Columnas.torre1.pop();
		}
		
		if(a==1&&b==3){
			Columnas.torre3.push(Columnas.torre1.peek());
			Columnas.torre1.pop();
		}
		
		if(a==2&&b==1){
			Columnas.torre1.push(Columnas.torre2.peek());
			Columnas.torre2.pop();
		}
		
		if(a==2&&b==3){
			Columnas.torre3.push(Columnas.torre2.peek());
			Columnas.torre2.pop();
		}
		
		if(a==3&&b==1){
			Columnas.torre1.push(Columnas.torre3.peek());
			Columnas.torre3.pop();
		}
		
		if(a==3&&b==2){
			Columnas.torre2.push(Columnas.torre3.peek());
			Columnas.torre3.pop();
		}
	}
}

public class Hanoi {

	public static void main(String[] args) {
		
		Scanner s=new Scanner(System.in);
		System.out.println("Ingrese el nœmero de elementos");
		Columnas.x=s.nextInt();
		Columnas.apilarTorre(Columnas.x);
		System.out.println("primer torre= "+Columnas.torre1);
		System.out.println("segunda torre= "+Columnas.torre2);
		System.out.println("tercer torre= "+Columnas.torre3);
		System.out.println();
		
		while(Columnas.torre2.size()!=(Columnas.x+1)&&Columnas.torre3.size()!=(Columnas.x+1)){
			
			System.out.println("Ingrese la primer torre");
			Verificar.a=s.nextInt();
			System.out.println("Ingrese la segunda torre");
			Verificar.b=s.nextInt();
			
			Verificar.verificar(Verificar.a, Verificar.b);
			
			System.out.println("primer torre= "+Columnas.torre1);
			System.out.println("segunda torre= "+Columnas.torre2);
			System.out.println("tercer torre= "+Columnas.torre3);
			System.out.println("Movimientos: "+Verificar.contador);
			System.out.println();
			
		}
		
		System.out.println("ha completado el juego");

	}

}
