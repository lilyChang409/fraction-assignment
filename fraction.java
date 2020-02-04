class fraction 
{
     private int ru, de;
    public fraction(){
        this.ru=0;
        this.de=1;
    }
    public fraction(int ru, int de){
         this.ru=ru;
        if(de==0){
        System.out.println("error!");
        de=1;
        }else{
        this.de=de;
    }
      
    }
    public fraction(String fraction){
          
     int slash=fraction.indexOf("/");
     int x=Integer.parseInt(fraction.substring(0,slash));
       this.ru=x;
     int y=Integer.parseInt(fraction.substring(slash+1));
        if (y==0){
            System.out.println("error!");
        this.de=1;
    }else{
        this.de=y;}
      
    }
    public fraction(fraction f){
        this.ru=f.ru;
        this.de=f.de;
       
    }
    public int getNum(){
        return this.ru;
    }
    public int getDe(){  
     return this.de;  
    }
   public String toString(){
      return  this.getNum()+"/"+this.getDe();
    }
   public Double toDouble(){
    double dounu=this.ru;
    double doude=this.de;
    return dounu/doude;
    }
    public int gcd(int a, int b){
        a=Math.abs(a);
        b=Math.abs(b);
        if(a==0 || b==0){
            return 1;
        }
        while(a!=b){
           if (a>b)
                a=a-b;
            else
                b= b-a;
        }
        return a;       
    }
  public void reduce() { 
        //reduces a fraction to lowest terms
        int gcd = gcd(this.ru, this.de);
        this.ru = this.ru / gcd;
        this.de = this.de / gcd; 
    
    }
    public void setNum(int ru){
        this.ru=ru;
    }
    public void setDe(int de){
     this.de=de;  
    }
  public static fraction mutiply(fraction a, fraction b){
       int ru=a.ru *b.ru;
      int de=a.de * b.de;
      fraction new1=new fraction(ru,de);
      new1.reduce();
      return new1;
   }
   public static fraction divide(fraction a, fraction b){
       if(b.ru==0){
           System.out.println("error!");
           return new fraction();
        }
        b.ru=b.de;
        b.de=b.ru;
        fraction new1=fraction.mutiply(a,b);
        new1.reduce();
        return new1;
    }
    public static fraction add(fraction a, fraction b){
        int newd=a.de*b.de;
        int newr=a.ru*b.de+b.ru*a.de;
        fraction new1=new fraction(newr,newd);
        new1.reduce();
        return new1;
    }
    public static fraction minus(fraction a, fraction b){
         int newd=a.de*b.de;
        int newr=a.ru*b.de-b.ru*a.de;
        fraction new1=new fraction(newr,newd);
        new1.reduce();
        return new1;
        
    }
  
}
