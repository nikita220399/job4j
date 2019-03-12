package croc.task2_2;

public class Service {
    private Department root;
    private int resultA = 0;
    private int resultB = 0;
    private int resultC = 0;
    private int result = 0;
    private int checkB = 0;
    private int prev = 0;
    private boolean flag = false;
    //private int i = 0;

    public int sum(Department department) {
        int max = 0;
        int res = 0;
        if (department.getChild().length != 0) {
            for (Department check : department.getChild()) {
                if (check.getTime() > max) {
                    max = check.getTime();
                }
                res += sum2(check);
            }
            res += max;
            res += department.getTime();
            return res;
        } else {
            return 0;
        }
    }

    private int sum2(Department department) {
        int max = 0;
        int res = 0;
        if (department.getChild().length != 0) {
            for (Department check : department.getChild()) {
                if (check.getTime() > max) {
                    max = check.getTime();
                }
                res += sum(check );
            }
            res += max;
            return res;
        } else {
            return 0;
        }
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
        int k = s.sum(d);
        System.out.println(k);
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
