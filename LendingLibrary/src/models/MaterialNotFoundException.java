package models;

public class MaterialNotFoundException extends Exception {

	    /**
	 * 
	 */
	private static final long serialVersionUID = -731798554737239088L;

		public MaterialNotFoundException() {
        // need to define default contructor since I define ny own
    }

    public MaterialNotFoundException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

//    public MaterialNotFoundException(Throwable cause) {
//        super(cause);
//        // TODO Auto-generated constructor stub
//    }
//
//    public MaterialNotFoundException(String message, Throwable cause) {
//        super(message, cause);
//        // TODO Auto-generated constructor stub
//    }

}
