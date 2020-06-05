public abstract class Duck {

  protected QuackBehavior quackBehavior;

  public void performQuack(){
    this.quackBehavior.quack();
  }

  public void setQuackBehavior(QuackBehavior qb){
    this.quackBehavior = qb;
  }

 
}