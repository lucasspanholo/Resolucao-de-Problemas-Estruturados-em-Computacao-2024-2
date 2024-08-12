import java.lang.reflect.Array;

public class Pilha<T> {
    private int top = -1;
    private T[] data;

    public Pilha(Class<T> clazz, int size) {
        // Utilizamos reflection para criar um array do tipo T
        data = (T[]) Array.newInstance(clazz, size);
    }

    public void push(T value) {
        if (isFull()) {
            System.out.println("A pilha está cheia.");
            return;
        }
        data[++top] = value;
    }

    public T pop() {
        if (isEmpty()) {
            System.out.println("A pilha está vazia.");
            return null;
        }
        return data[top--];
    }

    public void clear() {
        top = -1;
    }

    public boolean isFull() {
        return top == data.length - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("A pilha está vazia.");
            return null;
        }
        return data[top];
    }

    public static void main(String[] args) {
        // Exemplo de uso com Integer
        Pilha<Integer> pilha = new Pilha<>(Integer.class, 10);
        pilha.push(10);
        pilha.push(20);
        System.out.println("Topo da pilha: " + pilha.peek());
        System.out.println("Removido da pilha: " + pilha.pop());
        System.out.println("Topo da pilha: " + pilha.peek());

        // Exemplo de uso com String
        Pilha<String> pilhaString = new Pilha<>(String.class, 10);
        pilhaString.push("Olá");
        pilhaString.push("Mundo");
        System.out.println("Topo da pilha: " + pilhaString.peek());
        System.out.println("Removido da pilha: " + pilhaString.pop());
        System.out.println("Topo da pilha: " + pilhaString.peek());
    }
}
