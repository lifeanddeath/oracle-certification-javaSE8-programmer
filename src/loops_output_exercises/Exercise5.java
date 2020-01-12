package loops_output_exercises;

public class Exercise5 {

	public static void main(String[] args) {
		outer:
			   for ( int i = 0 ; i<3 ; i++ ){
			      for ( int j = 0 ; j<2 ; j++ ){
			         if ( i == j ){
			            continue outer;
			         }
			         System.out.println( "i=" + i + " , j=" + j );
			      }
			   }
	}

}
