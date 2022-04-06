package com.wdj;

public final class Manager extends Employee{

    private int bonus;

    public Manager(double s, int b) {
        super(s);
        bonus = b;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }

    @Override
    public double getSalary(){
        return super.getSalary() + (super.getSalary() * (float)(this.bonus/100));
    }
    
    @Override
    public void toShow(){
        System.out.println("Szef z wynagrodzeniem " + super.getSalary());
    }
}
