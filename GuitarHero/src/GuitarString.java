/**
 * This GuitarString object . . .
 * 
 * @author  
 * @version 
 */
public class GuitarString 
{
	private RingBuffer rb;
	private int N;			// size of the buffer for this string
	private double frequency;
	private int tics = 0;

	// create a guitar string of the given frequency
    public GuitarString(double frequency) {
    }

	// create a guitar string with size &
	// initial values given by the array
    public GuitarString(double[] array) {
    }

	// pluck the guitar string by replacing the buffer
	// with white noise
    public void pluck() {
		double value = 0.0;
		for (int i = 0; i < N; i++) {
			value = 0.5 * Math.sin(i * 2.0 * Math.PI * frequency / 44100.0);
			rb.remove();
			rb.add(value);
		}
    }

	/**
	* Apply the Karplus-Strong update: delete the sample at the
	* front of the ring buffer
	* and add to the end of the ring buffer the average
	* of the first two samples,
	* multiplied by the energy decay factor.
	*
	* From a mathematical physics viewpoint, the
	* Karplus-Strong algorithm approximately solves the 1D wave
	* equation, which describes the transverse motion
	* of the string as a function of time.
	*/
    public void tic() {
    }

    // return the current sample
    public double sample() {
        return 0.0;
    }

    // return number of times tic was called
    public int time() {
        return 0;
    }

    public static void main(String[] args) {
        double[] samples = { .2, .4, .5, .3, -.2, .4, .3, .0, -.1, -.3 };  
        GuitarString testString = new GuitarString(samples);
        for (int i = 0; i < 25; i++) {
            int t = testString.time();
            double sample = testString.sample();
            System.out.printf("%6d %8.4f\n", t, sample);
            testString.tic();
        }
    }
}
