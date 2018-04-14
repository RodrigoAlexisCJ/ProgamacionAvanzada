#include <cmath>
#include "Rac.h"
#include <stdio.h>


    /** 
     *  Clase para representar n\'umeros racionales
     *  @author Lamberto Maza Casas
     *  @version 2018.02.12
     */



int Rac::calc_mcd()
// don't delete the following line as it's needed to preserve source code of this autogenerated element
// section -64--88-56-1-57aeb27e:16186f3213c:-8000:0000000000000B37 begin
{
	int M,N,tmp,MCD;
	/*si numerador!=0 y denominador!=0, usar Algoritmo de Euclides*/
	if((n!=0)&&(d!=0)){
		if(n>d){
			M=abs(n);N=abs(d);
		}else{
			M=abs(d);N=abs(n);
		}/* ALGORITMO DE EUCLIDES (300 a.C.) */
		while((tmp=M%N)!=0){ /* M = QN + tmp */
			M=N;
			N=tmp;
		}/*cuando este while termina, en N se tiene el mcd*/
		MCD=N;
	}else{/*si no, hacer mcd=1*/
		MCD=1;/*Para evitar problemas cuando n=0 o d=0*/
	}
    return MCD;
}
// section -64--88-56-1-57aeb27e:16186f3213c:-8000:0000000000000B37 end
// don't delete the previous line as it's needed to preserve source code of this autogenerated element

void Rac::set_mcd(int MCD)
// don't delete the following line as it's needed to preserve source code of this autogenerated element
// section -64--88-56-1-57aeb27e:16186f3213c:-8000:0000000000000B39 begin
{
    mcd=MCD;
}
// section -64--88-56-1-57aeb27e:16186f3213c:-8000:0000000000000B39 end
// don't delete the previous line as it's needed to preserve source code of this autogenerated element

Rac& Rac::operator+(Rac& RacObj)
// don't delete the following line as it's needed to preserve source code of this autogenerated element
// section -64--88-56-1-57aeb27e:16186f3213c:-8000:0000000000000B48 begin
{
	Rac RacR;
	Rac& RacResult=RacR;
	RacResult.n=n*RacObj.d+d*RacObj.n;
	RacResult.d=d*RacObj.d;
	RacResult.set_mcd(RacResult.calc_mcd());
	RacResult.simplificar();
//	cout<<RacResult.n<<"/"<<RacResult.d<<endl;
	return RacResult;
}
// section -64--88-56-1-57aeb27e:16186f3213c:-8000:0000000000000B48 end
// don't delete the previous line as it's needed to preserve source code of this autogenerated element

Rac& Rac::operator-(Rac& RacObj)
// don't delete the following line as it's needed to preserve source code of this autogenerated element
// section -64--88-56-1-57aeb27e:16186f3213c:-8000:0000000000000B4C begin
{
	Rac RacR;
	Rac& RacResult=RacR;
	RacResult.n=n*RacObj.d-d*RacObj.n;
	RacResult.d=d*RacObj.d;
	RacResult.set_mcd(calc_mcd());
	RacResult.simplificar();
	return RacResult;
}
// section -64--88-56-1-57aeb27e:16186f3213c:-8000:0000000000000B4C end
// don't delete the previous line as it's needed to preserve source code of this autogenerated element

Rac& Rac::operator*(Rac& RacObj)
// don't delete the following line as it's needed to preserve source code of this autogenerated element
// section -64--88-56-1-57aeb27e:16186f3213c:-8000:0000000000000B4F begin
{
	Rac RacR;
	Rac& RacResult=RacR;
	RacResult.n=n*RacObj.n;
	RacResult.d=d*RacObj.d;
	RacResult.set_mcd(calc_mcd());
	RacResult.simplificar();
	return RacResult;
}
// section -64--88-56-1-57aeb27e:16186f3213c:-8000:0000000000000B4F end
// don't delete the previous line as it's needed to preserve source code of this autogenerated element

Rac& Rac::operator/(Rac& RacObj)
// don't delete the following line as it's needed to preserve source code of this autogenerated element
// section -64--88-56-1-57aeb27e:16186f3213c:-8000:0000000000000B52 begin
{
	Rac RacR;
	Rac& RacResult=RacR;
	RacResult.n=n*RacObj.d;
	RacResult.d=d*RacObj.n;
	RacResult.set_mcd(calc_mcd());
	RacResult.simplificar();
	return RacResult;
}
// section -64--88-56-1-57aeb27e:16186f3213c:-8000:0000000000000B52 end
// don't delete the previous line as it's needed to preserve source code of this autogenerated element

ostream& operator<<(ostream& ostreamOut, Rac& RacObj)
// don't delete the following line as it's needed to preserve source code of this autogenerated element
// section -64--88-56-1--2e9fd5a9:16187923f04:-8000:0000000000000B30 begin
{
	ostreamOut<<"\\frac{"<<RacObj.n<<"}{"\
//	ostreamOut<<RacObj.d<<"}"<<endl;
		      <<RacObj.d<<"}"<<endl;
	return ostreamOut;
}
// section -64--88-56-1--2e9fd5a9:16187923f04:-8000:0000000000000B30 end
// don't delete the previous line as it's needed to preserve source code of this autogenerated element

Rac::Rac(int intNum, int intDen):n(intNum),d(intDen)
// don't delete the following line as it's needed to preserve source code of this autogenerated element
// section -64--88-56-1--2e9fd5a9:16187923f04:-8000:0000000000000B35 begin
{
	set_mcd(calc_mcd());
}
// section -64--88-56-1--2e9fd5a9:16187923f04:-8000:0000000000000B35 end
// don't delete the previous line as it's needed to preserve source code of this autogenerated element

Rac::Rac():mcd(1) /*para evitar divisi\'on entre cero si se llama a simplificar*/
// don't delete the following line as it's needed to preserve source code of this autogenerated element
// section -64--88-56-1--2e9fd5a9:16187923f04:-8000:0000000000000B39 begin
{
}
// section -64--88-56-1--2e9fd5a9:16187923f04:-8000:0000000000000B39 end
// don't delete the previous line as it's needed to preserve source code of this autogenerated element

void Rac::simplificar()
// don't delete the following line as it's needed to preserve source code of this autogenerated element
// section -64--88-56-1--2e9fd5a9:16187923f04:-8000:0000000000000B3B begin
{
	n=n/mcd;
	d=d/mcd;    
}
// section -64--88-56-1--2e9fd5a9:16187923f04:-8000:0000000000000B3B end
// don't delete the previous line as it's needed to preserve source code of this autogenerated element

//ostream& operator<<=(ostream& ostreamOut,Rac& RacObj){
//	Rac R1=RacObj;
//	ostreamOut<<R1;
//	return ostreamOut;
//}
Rac::Rac(const Rac& R):n(R.n),d(R.d)
{
//	n=R.n;
//	d=R.d;
	mcd=calc_mcd();
}

Rac& Rac::operator+(int intVal)
{
	Rac op(intVal,1),R;
	R=*this+op;
	Rac& r=R;
	return r;
}

Rac& operator+(int intVal,Rac& RacObj)
{
	Rac op(intVal,1),R;
	R=op+RacObj;
	Rac& r=R;
	return r;
}

std::string Rac::string_show(){
//	string& result;
	char str[128];
	sprintf(str,"%d/%d",n,d);
	string Result=string(str);
//	string& result=Result;
	return Result; 
}



