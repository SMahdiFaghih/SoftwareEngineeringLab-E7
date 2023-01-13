package parser;

public class Action
{
    private final act action;
    private final int number;

    public Action(act action, int number)
    {
        this.action = action;
        this.number = number;
    }

    public String toString()
    {
        switch (getAction())
        {
            case accept:
                return "acc";
            case shift:
                return "s" + getNumber();
            case reduce:
                return "r" + getNumber();
        }
        return getAction().toString() + getNumber();
    }

    public act getAction()
    {
        return action;
    }

    public int getNumber()
    {
        return number;
    }
}

enum act
{
    shift, reduce, accept
}
