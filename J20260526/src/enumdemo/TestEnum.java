package enumdemo;

public enum TestEnum {
    RED(1,"红色"),BLACK(2,"黑色"),GREEN(3,"绿色");

    public String color;
    public int ordinal;
    private TestEnum(int ordinal,String color) {
        this.color = color;
        this.ordinal = ordinal;
    }

    public static void main(String[] args) {
        TestEnum[] testEnums = TestEnum.values();
        for(int i = 0;i < testEnums.length;i++) {
            System.out.println(testEnums[i] + " ordinal: " + testEnums[i].ordinal());
        }
        TestEnum test = TestEnum.valueOf("RED");
        System.out.println(test);
    }

    public static void main1(String[] args) {
        TestEnum testEnum = TestEnum.RED;
        switch (testEnum) {
            case BLACK:
                System.out.println("黑色");
                break;
            case RED:
                System.out.println("红色");
                break;
            case GREEN:
                System.out.println("绿色");
                break;
            default:
                System.out.println("其他颜色");
                break;
        }
    }

}
