public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public static final double G=6.67e-11;
    public Planet(double xP, double yP, double xV,
                  double yV, double m, String img)
    {
        this.xxPos=xP;
        this.yyPos=yP;
        this.mass=m;
        this.xxVel=xV;
        this.yyVel=yV;
        this.imgFileName=img;
    }
    public Planet(Planet p)
    {
        this.xxPos=p.xxPos;
        this.yyPos=p.yyPos;
        this.mass=p.mass;
        this.xxVel=p.xxVel;
        this.yyVel=p.yyVel;
        this.imgFileName=p.imgFileName;
    }
    public double calcDistance(Planet p)
    {
        return Math.sqrt((xxPos-p.xxPos)*(xxPos-p.xxPos)+(yyPos-p.yyPos)*(yyPos-p.yyPos));
    }
    public double  calcForceExertedBy(Planet p)
    {
        return G*mass*p.mass/(calcDistance(p)*calcDistance(p));
    }
    public double  calcForceExertedByX(Planet p)
    {
        return G*mass*p.mass/(calcDistance(p)*calcDistance(p))*(p.xxPos-xxPos)/calcDistance(p);
    }
    public double  calcForceExertedByY(Planet p)
    {
        return G*mass*p.mass/(calcDistance(p)*calcDistance(p))*(p.yyPos-yyPos)/calcDistance(p);
    }
    public double  calcNetForceExertedByX(Planet[] p)
    {
        double sum=0;
        for (Planet x:p)
        {
            if (!this.equals(x))
            {
                sum+=calcForceExertedByX(x);
            }
        }
        return sum;
    }
    public double  calcNetForceExertedByY(Planet[] p)
    {
        double sum=0;
        for (Planet x:p)
        {
            if (!this.equals(x))
            {
                sum+=calcForceExertedByY(x);
            }
        }
        return sum;
    }
    public void update(double dt, double fX, double fY)
    {
        double aY=fY/mass;
        double aX=fX/mass;
        xxVel=xxVel+dt*aX;
        yyVel=yyVel+dt*aY;
        xxPos=xxPos+dt*xxVel;
        yyPos=yyPos+dt*yyVel;
    }
    public void draw()
    {
        String imageToDraw ="images/"+imgFileName;
        StdDraw.picture(xxPos, yyPos, imageToDraw);
        StdDraw.show();
    }
}
