package code.designpattern.structural;

abstract class Beverage {

  abstract double cost();

  abstract String description();
}

class DarkRoast extends Beverage {

  @Override
  public double cost() {
    return 3.45;
  }

  @Override
  public String description() {
    return "Dark Roast";
  }
}

class LightRoast extends Beverage {

  @Override
  public double cost() {
    return 3.45;
  }

  @Override
  public String description() {
    return "Light Roast";
  }
}

abstract class BeverageDecorator extends Beverage {

  protected Beverage beverage;

  public BeverageDecorator(Beverage beverage) {
    this.beverage = beverage;
  }
}

class EspressoDecorator extends BeverageDecorator {

  public EspressoDecorator(Beverage beverage) {
    super(beverage);
  }

  @Override
  public double cost() {
    return 0.5 + beverage.cost();
  }

  @Override
  public String description() {
    return beverage.description() + ", Espresso";
  }
}

class CreamDecorator extends BeverageDecorator {

  public CreamDecorator(Beverage beverage) {
    super(beverage);
  }

  @Override
  public double cost() {
    return 0.3 + beverage.cost();
  }

  @Override
  public String description() {
    return beverage.description() + ", Cream";
  }
}

class FoamDecorator extends BeverageDecorator {

  public FoamDecorator(Beverage beverage) {
    super(beverage);
  }

  @Override
  public double cost() {
    return 0.2 + beverage.cost();
  }

  @Override
  public String description() {
    return beverage.description() + ", Foam";
  }
}

class Decorator {

  public static void main(String[] args) {
    Beverage beverage = new FoamDecorator(
        new CreamDecorator(new EspressoDecorator(new LightRoast()))
    );
    System.out.println(beverage.description()); // Light Roast, Espresso, Cream, Foam
    System.out.println(beverage.cost()); // 4.45
  }
}
