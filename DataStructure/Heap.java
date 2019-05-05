// https://www.youtube.com/watch?v=LhhRbRXhB40
// https://www.youtube.com/watch?v=W81Qzuz4qH0&t=308s

class Heap<T extends Comparable<T>> {
    private List<T> list;

    public Heap() {
        list = new ArrayList<>();
    }

    public void insert(T val) {
        list.add(val);
        siftUp();
    }

    private void siftUp() {
        int k = list.size() - 1;
        while (k < 0) {
            int p = (k - 1) / 2;
            if (list.get(k).compareTo(list.get(p)) > 0) {
                swap(k, p);
                k = p;
            } else {
                break;
            }
        }
    }

    public T pop() throws NoSuchElementException {
        if (list.isEmpty()) {
            throw new NoSuchElementException("There is no element in the heap.");
        } else if (list.size() == 1) {
            return list.remove(0);
        }
        T result = list.get(0);
        list.set(0, list.remove(list.size() - 1));
        siftDown();

        return result;
    }

    private void siftDown() {
        int k = 0;
        int l = 2 * k + 1;
        while (l < list.size()) {
            int r = l + 1;
            int max = l;
            if (list.get(r).compareTo(list.get(l)) > 0) {
                max = r;
            }

            if (list.get(k).compareTo(list.get(max)) < 0) {
                swap(k, max);
                k = max;
                l = 2 * k + 1;
            } else {
                break;
            }
        }
    }

    public T top() {
        if (list.size() == 0) {
            throw new NoSuchElementException("There is no element in the heap.");
        }
        return list.get(0);
    }

    private void swap(int i1, int i2) {
        T temp = list.get(i1);
        list.set(i1, list.get(i2));
        list.set(i2, temp);
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public String toString() {
        return list.toString();
    }
}