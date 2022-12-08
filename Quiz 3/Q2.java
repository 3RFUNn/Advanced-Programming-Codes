import java.lang.Comparable;

public class Question2 {
    class Utility {
        void removeRepetition(Question2.Shape[] arr) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[i].compareTo(arr[j]) == 0) {
                        if (arr.length - j + 1 >= 0) System.arraycopy(arr, j + 1, arr, j + 1 - 1, arr.length - j + 1);
                    }
                }
            }
        }
    }

    public interface Shape {
        int getArea();

        int compareTo(Object object);
    }

    class Rectangle implements Shape {
        int big, little;

        public int getArea() {
            return big * little;
        }

        public int compareTo(Object object) {
            if (object instanceof Circle) {
                Circle circle = (Circle) object;
                return Integer.compare(this.getArea(), circle.getArea());
            } else {
                Rectangle m2 = (Rectangle) object;
                return Integer.compare(this.getArea(), m2.getArea());
            }
        }
    }

    class Circle implements Shape {
        int shoa;

        public int getArea() {
            return (3 * shoa * shoa);
        }

        public int compareTo(Object object) {
            if (object instanceof Circle) {
                Circle circle = (Circle) object;
                return Integer.compare(this.getArea(), circle.getArea());
            } else {
                Rectangle m1 = (Rectangle) object;
                return Integer.compare(this.getArea(), m1.getArea());
            }

        }


    }
}
