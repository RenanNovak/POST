
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

interface TesteApi {

    //Listar Todas Tarefas
    @Headers("Student:1144002407")
    @GET("tasks")
    Call<List<Task>> getTask();

    //Listar Tarefa por ID
    @Headers("Student:1144002407")
    @GET("tasks/{id}")
    Call<Task>
    Listaid (@Path("id") Integer id);

    //Nova Tarefa
    @Headers("Student:1144002407")
    @POST("tasks")
    Call<Task>
    AddTask(@Body Task description);

    //Alterar Tarefa por ID
    @Headers("Student:1144002407")
    @PUT("tasks/{id}")
    Call<Void> updateTask(@Path("id") Integer id, @Body String description);

    //Deletar tarefa por ID
    @Headers("Student:1144002407")
    @DELETE("tasks/{id}")
    Call<Void>
    DeleteId (@Path("id") Integer id);
}

