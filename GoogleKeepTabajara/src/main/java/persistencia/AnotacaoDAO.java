/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import negocio.Anotacao;
import redis.clients.jedis.search.IndexDefinition.Type;

/**
 *
 * @author iapereira
 */
public class AnotacaoDAO {

    private Conexao conexao;
    private Gson gson;

    public AnotacaoDAO() {
        this.gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .create();

    }

    public void atualizar(Anotacao anotacao) {
        this.conexao = new Conexao();
        if (this.conexao.getConexao().exists(anotacao.getId().toString())) {
            this.conexao.getConexao().set(anotacao.getId().toString(), this.gson.toJson(anotacao));
        }
        this.conexao.fechar();

    }

    public void adicionar(Anotacao anotacao) {

        this.conexao = new Conexao();
        this.conexao.getConexao().set(anotacao.getId().toString(), this.gson.toJson(anotacao));
        this.conexao.fechar();
    }

    public Anotacao obter(String id) {
        this.conexao = new Conexao();
        Anotacao anotacao = this.gson.fromJson(this.conexao.getConexao().get(id), Anotacao.class);
        this.conexao.fechar();
        return anotacao;

    }

    public void remover(UUID id) {
        this.conexao = new Conexao();
        this.conexao.getConexao().del(id.toString());
        this.conexao.fechar();

    }

    public List<Anotacao> listar() {
        this.conexao = new Conexao();
        Set<String> vetLabels = this.conexao.getConexao().keys("*");
        Iterator iterator = vetLabels.iterator();
        List<Anotacao> vetAnotacao = new ArrayList<>();
        while (iterator.hasNext()) {
            Object id = iterator.next();            
            String json = this.conexao.getConexao().get(id.toString());
            Anotacao anotacao = this.gson.fromJson(json, Anotacao.class);
            vetAnotacao.add(anotacao);

        }
        this.conexao.fechar();
        return vetAnotacao;
    }

    class LocalDateAdapter implements JsonSerializer<LocalDate>, JsonDeserializer<LocalDate> {

        private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        @Override
        public JsonElement serialize(LocalDate t, java.lang.reflect.Type type, JsonSerializationContext jsc) {
            return new JsonPrimitive(t.format(formatter));
        }

        @Override
        public LocalDate deserialize(JsonElement json, java.lang.reflect.Type typeOfT,
                JsonDeserializationContext context) throws JsonParseException {
            return LocalDate.parse(json.getAsString(), formatter);
        }
    }

}
