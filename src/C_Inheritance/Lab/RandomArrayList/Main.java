//05. Random Array List
package C_Inheritance.Lab.RandomArrayList;

class Main {
    public static void main(String[] args) {

        RandomArrayList randomArrayList = new RandomArrayList();

        randomArrayList.add(1);
        randomArrayList.add(2);
        randomArrayList.add(3);

        System.out.println(randomArrayList.getRandomElement());
        System.out.println(randomArrayList);
    }
}
