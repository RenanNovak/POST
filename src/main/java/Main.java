import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

public class Main {
public static  void main (String args[]) {

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://ec2-35-166-113-35.us-west-2.compute.amazonaws.com/api/")

            .addConverterFactory(GsonConverterFactory.create())
            .build();

    TesteApi api = retrofit.create(TesteApi.class);

    //Listar Todas Tarefas
    try {
        Call<List<Task>> call = api.getTask();

        Response<List<Task>> r = call.execute();

        List<Task> t = r.body();

        System.out.println("Todas as Tarefas [GET] : \n" +t+"\n");

    } catch (Exception e)
    {
        e.printStackTrace();
    }

    //Listar Tarefa por ID
    try {
        Task listId = new Task ();
        Call<Task> call = api.Listaid(1408);

        Response<Task> r = call.execute();

        Task t = r.body();

        System.out.println("Tarefa por [GetID] : "+t+"\n");

    } catch (Exception e)
    {
        e.printStackTrace();
    }

    //Nova Tarefa
    try {
        Task post = new Task ();
        post.setDescription("TESTE");
        post.setDone(true);
        Call<Task> call = api.AddTask(post);

        Response<Task> r = call.execute();

        Task t = r.body();

        System.out.println("Nova Tarefa [POST] : "+ t+"\n");

    } catch (Exception e)
    {
        e.printStackTrace();
    }


//    //Alterar Tarefa por ID
//    try {
//        Task put = new Task ();
//        Call<Void> call = api.updateTask(1401, "ALTERANDO TAREFA");
//        Response<Void> r = call.execute();
//
//        Void t = r.body();
//
//        System.out.println("Tarefa Alterada [PUT] : "+t+"\n");
//
//    } catch (Exception e)
//    {
//        e.printStackTrace();
//    }
//
    //Deletar tarefa por ID
    try {
        Task delete = new Task ();
        Call<Void> call = api.DeleteId(1410);

        Response<Void> r = call.execute();

        Void t = r.body();

        System.out.println("Tarefa Deletada [DELETE] : "+t+"\n");

    } catch (Exception e)
    {
        e.printStackTrace();
    }

}


}
