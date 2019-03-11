package croc.task2_2;

public class Service {
    private Department root;
    private int result;

    public void sum(Department department) {
        this.result += department.getTime();
        if (department.getChild().length != 0) {
            for (Department check : department.getChild()) {
                sum(check);
            }
        } else {
            return;
        }
    }

    public Department setup() {
        Department[] depsC1 = {new Department(new Department[]{}, 11, "DepC1"),
                new Department(new Department[]{}, 3, "DepC2"),
                new Department(new Department[]{}, 6, "DepC3")};
        Department[] depsC2 = {new Department(new Department[]{}, 2, "DepC1"),
                new Department(new Department[]{}, 3, "DepC2"),
                new Department(new Department[]{}, 6, "DepC3")};
        Department[] depsC3 = {new Department(new Department[]{}, 2, "DepC1"),
                new Department(new Department[]{}, 3, "DepC2"),
                new Department(new Department[]{}, 6, "DepC3")};

        Department[] depsB = {new Department(depsC1, 2, "DepB1"),
                new Department(depsC2, 3, "DepB2"),
                new Department(depsC3, 6, "DepB3")};

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
