public class DuckSimulator {

  public static void main(String[] args) {
    Duck md = new MallarDuck();

    md.performQuack();

    md.setQuackBehavior(new RegularQuack());
    md.performQuack();
  }
}