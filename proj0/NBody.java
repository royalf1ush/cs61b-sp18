public class NBody {
    public static double readRadius(String name)
    {
        In in = new In(name);
        int num=in.readInt();
        double radius=in.readDouble();
        return radius;
    }
    public static Planet[] readPlanets(String name)
    {
        In in = new In(name);
        int num=in.readInt();
        Planet[] p=new Planet[num];
        double radius=in.readDouble();
        for (int i=0;i<num;i++)
        {
            double firstItemInFile = in.readDouble();
            double secondItemInFile = in.readDouble();
            double thirdItemInFile = in.readDouble();
            double fourthItemInFile = in.readDouble();
            double fifthItemInFile = in.readDouble();
            String planet=in.readString();
            p[i]=new Planet(firstItemInFile,secondItemInFile,thirdItemInFile,fourthItemInFile,fifthItemInFile,planet);
        }
        return p;
    }
    public static void main(String[] args)
    {
        StdDraw.enableDoubleBuffering();
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename=args[2];
        double radius=readRadius(filename);
        Planet [] p=readPlanets(filename);
        String imageToDraw ="images/starfield.jpg";
        StdDraw.setScale(-radius, radius);
        StdDraw.clear();
        StdDraw.picture(0, 0, imageToDraw);
        StdDraw.show();
        for (Planet x:p)
        {
            x.draw();
        }
        for(double t=0;t<=T;t+=dt)
        {
            double [] xForces=new double[p.length];
            double [] yForces=new double[p.length];
            for(int i=0;i<p.length;i++)
            {
                xForces[i]=p[i].calcNetForceExertedByX(p);
                yForces[i]=p[i].calcNetForceExertedByY(p);
            }
            for(int i=0;i<p.length;i++)
            {
                p[i].update(dt,xForces[i],yForces[i]);
            }
            StdDraw.clear();
            StdDraw.picture(0, 0, imageToDraw);
            for(int i=0;i<p.length;i++)
            {
                p[i].draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
        }
        StdOut.printf("%d\n", p.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < p.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    p[i].xxPos, p[i].yyPos, p[i].xxVel,
                    p[i].yyVel, p[i].mass, p[i].imgFileName);
        }
    }
}
