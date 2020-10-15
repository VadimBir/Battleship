import java.io.Serializable;

public class ControlShipPlacement{

    private Command Cmd[];

    public ControlShipPlacement(Command arr[]) // there can be multiple commands for different items, array would allow to not create similar default contractors has one, two, or three command inputs. 
    {
        Cmd = new Command[arr.length];
        for(int i = 0; i < arr.length; i++ ){
            this.Cmd[i]=arr[i];
        }
    }

    public void CmdArr(int i)
    {
        Cmd[i].execute();
    }
}