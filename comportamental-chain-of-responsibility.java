abstract class Handler {
    protected Handler successor;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    public abstract void handleRequest(Request request);
}

class ConcreteHandler1 extends Handler {
    public void handleRequest(Request request) {
        if (request.getType() == RequestType.TYPE1) {
            System.out.println("ConcreteHandler1 handling request " + request.getDescription());
        } else if (successor != null) {
            successor.handleRequest(request);
        }
    }
}

class ConcreteHandler2 extends Handler {
    public void handleRequest(Request request) {
        if (request.getType() == RequestType.TYPE2) {
            System.out.println("ConcreteHandler2 handling request " + request.getDescription());
        } else if (successor != null) {
            successor.handleRequest(request);
        }
    }
}

class ConcreteHandler3 extends Handler {
    public void handleRequest(Request request) {
        if (request.getType() == RequestType.TYPE3) {
            System.out.println("ConcreteHandler3 handling request " + request.getDescription());
        } else if (successor != null) {
            successor.handleRequest(request);
        }
    }
}

enum RequestType {
    TYPE1, TYPE2, TYPE3
}

class Request {
    private RequestType type;
    private String description;

    public Request(RequestType type, String description) {
        this.type = type;
        this.description = description;
    }

    public RequestType getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }
}

public class Main {
    public static void main(String[] args) {
        Handler handler1 = new ConcreteHandler1();
        Handler handler2 = new ConcreteHandler2();
        Handler handler3 = new ConcreteHandler3();

        handler1.setSuccessor(handler2);
        handler2.setSuccessor(handler3);

        Request request1 = new Request(RequestType.TYPE1, "Request 1");
        Request request2 = new Request(RequestType.TYPE2, "Request 2");
        Request request3 = new Request(RequestType.TYPE3, "Request 3");
        Request request4 = new Request(RequestType.TYPE3, "Request 4");

        handler1.handleRequest(request1);
        handler1.handleRequest(request2);
        handler1.handleRequest(request3);
        handler1.handleRequest(request4);
    }
}