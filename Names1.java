/* Names.java */



class Names1 {

/** Performs various string operations on the name John Fitzgerald Kennedy.
 *  @param arg is not used.
 */
  public static void main(String arg[]) {
    String first = "Rahul";
    String middle = "Rajnikanth";
    String last = "Sachinn";
    String initials;
    String firstInit, middleInit, lastInit;

    firstInit = first.substring(0,1);
    middleInit = middle.substring(0,1);
    lastInit = last.substring(0,1);
    initials = firstInit.concat(middleInit);
    initials = initials.concat(lastInit);

    System.out.println();
    System.out.println(first + " " + middle + " " + last + " ");
    System.out.println(initials);
    System.out.println(last + ", " + first + " " + middle);
    System.out.println(last + ", " + first + " " + middleInit +".");
    System.out.println(first.toUpperCase() + " " + last.toUpperCase());

    System.out.println(first + " equals rahul is " + first.equals("rahul"));
    System.out.println(first + " equals rahul (ignoring case) is " 
		       + first.equalsIgnoreCase("rahul"));
    System.out.println("The character at index 3 in " + middle + " is " +
		       middle.substring(1,3));
    System.out.println("The index of \"rajni\" within " + middle + " is " +
		       middle.indexOf("rajni"));
    System.out.println("The index of \"rajni\" within " + last + " is " +
		       last.indexOf("rajni"));

    System.out.println();
  }
}