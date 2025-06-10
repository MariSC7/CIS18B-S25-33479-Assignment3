interface Observer {
    void update(String message);
}

// Todo: Implement TransactionLogger class (Concrete Observer)
class TransactionLogger implements Observer {
    @Override 
    public void update(String message) {
        System.out.println("Transaction Log: " + message); // Prints Transaction Message
    }
}
