package croc.task2_2;

public class Service {
    private Department root;
    private int resultA = 0;
    private int resultB = 0;
    private int resultC = 0;
    private int result = 0;
    private int checkB = 0;

    public void sum(Department department) {
//        int checkC = 0;
//        this.result += (department.getTime());
//        if (department.getName().equals("DepB") && department.getTime() > checkB) {
//            checkB = department.getTime();
//
//        }
//        if (department.getName().equals("DepC") && department.getTime() > checkC) {
//            checkC = department.getTime();
//        }
//
//        if (department.getChild().length != 0) {
//            for (int i = 0; i < department.getChild().length; i++) {
//                sum(department.getChild()[i]);
//            }
//        } else {
//            return;
//        }
        resultA = department.getTime();
        if (department.getChild().length != 0) {
            for (Department d : department.getChild()) {
                int checkC = 0;
                if (d.getTime() > checkB) {
                    checkB = d.getTime();
                }
                if (d.getChild().length != 0) {
                    for (Department d2 : d.getChild()) {
                        if (d2.getTime() > checkC) {
                            checkC = d2.getTime();
                        }
                    }
                    resultC += checkC;
                }
            }
            resultB += checkB;
        }
        result = resultA + resultB + resultC;
    }

    public Department setup() {
        Department[] depsC1 = {new Department(new Department[]{}, 11, "DepC"),
                new Department(new Department[]{}, 3, "DepC"),
                new Department(new Department[]{}, 6, "DepC")};
        Department[] depsC2 = {new Department(new Department[]{}, 2, "DepC"),
                new Department(new Department[]{}, 3, "DepC"),
                new Department(new Department[]{}, 6, "DepC")};
        Department[] depsC3 = {new Department(new Department[]{}, 2, "DepC"),
                new Department(new Department[]{}, 3, "DepC"),
                new Department(new Department[]{}, 6, "DepC")};

        Department[] depsB = {new Department(depsC1, 2, "DepB"),
                new Department(depsC2, 3, "DepB"),
                new Department(depsC3, 6, "DepB")};

        Department depA = new Department(depsB, 13, "DepA");

        this.root = depA;
        return this.root;
    }

    public static void main(String[] args) {
        Service s = new Service();
        Department d = s.setup();
        s.sum(d);
        System.out.println(s.getResult());
    }

    public Department getRoot() {
        return root;
    }

    public void setRoot(Department root) {
        this.root = root;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
