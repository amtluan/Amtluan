package javaapplication25;

public final class Fractionn {
	private int numerator;        
	private int denominator;    
      public   Fractionn() {
        numerator = 0;
        denominator = 1;
    }
	public Fractionn(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }
    //accessor for numerator
   public int getNumerator() {
        return numerator;
    }
    //mutator for numerator
    public void setNumerator(int num) {
        numerator = num;
    }
    //accessor for denominator
   public int getDenominator() {
        return denominator;
    }
    //mutator for 
   public void setDenominator(int denom) {
        denominator = denom;
    }
   public int gcd(int a, int b) {
         a=Math.abs(a);
         b=Math.abs(b);
         while (a!=b)
         {
             if (a>b)
             {
                 a-=b;
             }
             else {
                 b-=a;
         }
     }
            return a;
  }  
    public void simplifyFraction()
    {
        int i = gcd(this.getNumerator(),this.getDenominator());
        this.setNumerator(this.getNumerator()/i);
        this.setDenominator(this.getDenominator()/i);
    }
	public Fractionn add( Fractionn otherFraction )
	{
		int commonDenominator  = this.getDenominator() * otherFraction.getDenominator();
		int newNumerator = ( this.getNumerator() * otherFraction.getDenominator() ) + ( otherFraction.getNumerator() * this.getDenominator() );
		Fractionn result = new Fractionn( newNumerator, commonDenominator );
		result.simplifyFraction();
            return result;
	}
	public Fractionn subtract( Fractionn otherFraction )
	{
		int commonDenominator = this.getDenominator()* otherFraction.getDenominator();
		int newNumerator = ( this.getNumerator() * otherFraction.getDenominator() ) - ( otherFraction.getNumerator() * this.getDenominator() );
		Fractionn result = new Fractionn( newNumerator, commonDenominator );
                result.simplifyFraction();    
		return result;
	}
	public Fractionn multiply( Fractionn otherFraction )
	{
                int newNumerator = this.getNumerator() * otherFraction.getNumerator();
                int newDenominator = this.getDenominator() * otherFraction.getDenominator();
                Fractionn result = new Fractionn( newNumerator, newDenominator );
                result.simplifyFraction();    
		return result;
	}
	public Fractionn divide( Fractionn otherFraction ) throws ArithmeticException
	{
                if( otherFraction.getNumerator() == 0 )
                {
                    throw new ArithmeticException( "Division by Zero" );
                }
		Fractionn inverse = new Fractionn( otherFraction.getDenominator(), otherFraction.getNumerator() );
		Fractionn result = this.multiply( inverse);
                result.simplifyFraction();
		return result;
	}
public void output()
{
    System.out.println(+numerator+"/"+denominator);
}}


