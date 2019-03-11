package NPV;

public class NetPresentValue {

    private double annualGain;
    private double initialInvestment;
    private double discountRate;
    private double usefulLife;

    public NetPresentValue(double annualGain, double initialInvestment, double discountRate, double usefulLife) {
        this.annualGain = annualGain;
        this.initialInvestment = initialInvestment;
        this.discountRate = discountRate;
        this.usefulLife = usefulLife;
    }

    public double computeNetPresentValue() throws ValueError {

        if (this.discountRate==0) {
            throw new ValueError("ValueError: Zero Discount Rate is passed to function. Division by 0.");
        }

        double quotient = (1-(1/(Math.pow(1+this.discountRate,this.usefulLife))))/this.discountRate;
        double res = (this.annualGain*quotient)-this.initialInvestment;
        return res;
    }
}