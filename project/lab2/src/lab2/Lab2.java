package javaapplication25;
public final class Fraction {
	private int numerator;        
	private int denominator;    
      public   Fraction() {
        numerator = 0;
        denominator = 1;
    }
	public Fraction(int numerator, int denominator) {
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

	public Fraction add( Fraction otherFraction )
	{
		int commonDenominator  = this.getDenominator() * otherFraction.getDenominator();
		int newNumerator = ( this.getNumerator() * otherFraction.getDenominator() ) + ( otherFraction.getNumerator() * this.getDenominator() );
		Fraction result = new Fraction( newNumerator, commonDenominator );
		result.simplifyFraction();
            return result;

	}
	public Fraction subtract( Fraction otherFraction )
	{
		int commonDenominator = this.getDenominator()* otherFraction.getDenominator();
		int newNumerator = ( this.getNumerator() * otherFraction.getDenominator() ) - ( otherFraction.getNumerator() * this.getDenominator() );

		Fraction result = new Fraction( newNumerator, commonDenominator );
                result.simplifyFraction();    
		return result;

	}

	public Fraction multiply( Fraction otherFraction )
	{

                int newNumerator = this.getNumerator() * otherFraction.getNumerator();
                int newDenominator = this.getDenominator() * otherFraction.getDenominator();

                Fraction result = new Fraction( newNumerator, newDenominator );
                result.simplifyFraction();    
		return result;

	}
	public Fraction divide( Fraction otherFraction ) throws ArithmeticException
	{

                if( otherFraction.getNumerator() == 0 )
                {

                    throw new ArithmeticException( "Division by Zero" );

                }

		Fraction inverse = new Fraction( otherFraction.getDenominator(), otherFraction.getNumerator() );

		Fraction result = this.multiply( inverse);
                result.simplifyFraction();
		return result;

	}
public void output()
{
    System.out.println(+numerator+"/"+denominator);
}}