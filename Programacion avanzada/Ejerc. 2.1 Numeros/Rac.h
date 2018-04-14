/*RAc (int intnum, int intden) constructor (se llama igual que la clase, pero sin un tipo de retorno)
friend ()
<<operador de insercción de flujo
*/
#include <iostream>
using namespace std;
#ifndef Rac_h
#define Rac_h
struct Rac{
	int calc_mcd();
	void set_mcd(int MCD);
	Rac& operator+(Rac& RacObj);
	Rac& operator-(Rac& RacObj);
	Rac& operator*(Rac& RacObj);
	Rac& operator/(Rac& RacObj);
	Rac& operator+(int intVal);
	friend Rac& operator+(int intVal,Rac& RacObj);
	friend ostream& operator<<(ostream& ostreamOut, Rac& RacObj);//friend indica que es una función amiga de la clase
	//cuando no se coloca el prototipo indica un método y cuando no indica una función amiga
	//la diferencia es que las funciones amigas pueden recibir más de un argumento
	//en este caso usamos el flujo ostreamOut para imprimir un racional 
	//cout<<r<<endl; mandamos el racional al flujo cout
	
	//friend ostream& operator<<=(ostream& ostreamOut, Rac& RacObj);
	Rac(const Rac&);
	Rac(int intNum, int intDen);
	Rac();
	Rac(int){ }
	void simplificar();
	int n;
	int d;
	int mcd;
};//end struct Rac



#endif 
