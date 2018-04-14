#include "Rac.h"

int Rac::calc_mcd()
//

{
	int M,N,tmp,MCD;
	
	if((n!=0)&&(d!=0)){
		if(n>d){
			M=n; N=d;
		} else{
			M=d;N=n;
		}
		while((tmp=M%N)!=0){
			M=N;
			N=tmp;
		}
		MCD=N;
	}else{
		MCD=1;
	}
	return MCD;
}

void Rac::set_mcd(int MCD)
{
	mcd=MCD;
}

ostream& operator<<(ostream& ostreamOut, Rac& RacObj)
// don't delete the following line as it's needed to preserve source code of this autogenerated element
// section -64--88-56-1--2e9fd5a9:16187923f04:-8000:0000000000000B30 begin
{
	ostreamOut<<"\\frac{"<<RacObj.n<<"}{"\
//	ostreamOut<<RacObj.d<<"}"<<endl;
		      <<RacObj.d<<"}"<<endl;
	return ostreamOut;
}
