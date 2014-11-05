import java.util.Scanner;

public class Spectrum
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        System.out.print("Imput a wavelength value: " );
        double wave = s.nextDouble();
        if (wave < Math.pow(10,-11))
        {
            System.out.println(wave + " is a gamma ray.");
        }
        else if (wave < Math.pow(10,-8) && wave >= Math.pow(10,-11))
        {
            System.out.println(wave+ " is an x-ray.");
        }
        else if (wave <  (4 * Math.pow(10,-7)) && wave >= Math.pow(10,-8))
        {
            System.out.println(wave+ " is an ultraviolet ray.");
        }
        else if (wave <  (7 * Math.pow(10,-7)) && wave >= (4 * Math.pow(10,-7)))
        {
            System.out.println(wave+ " is a visible light wave.");
        }
        else if (wave <  Math.pow(10,-3) && wave >= (7 * Math.pow(10,-7)))
        {
            System.out.println(wave+ " is an infrared wave.");
        }
        else if (wave <  Math.pow(10,-1) && wave >= Math.pow(10,-3))
        {
            System.out.println(wave+ " is an microwave.");
        }
        else if (wave <= Math.pow(10,-1))
        {
            System.out.println(wave+ " is a radio wave.");
        }
    }

}
