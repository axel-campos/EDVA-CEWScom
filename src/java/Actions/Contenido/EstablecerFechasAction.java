package Actions.Contenido;

import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import modelo.dao.ContenidoEtapaDAO;
import modelo.dao.EtapaDAO;
import modelo.pojo.Etapa;

public class EstablecerFechasAction extends ActionSupport  {
    
    private String idContenido;
    private List<Etapa> etapas;
    
    @Override
    public String execute() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void cargaEtapas(){
        ContenidoEtapaDAO contEtapaDAO = new ContenidoEtapaDAO();
        String sql = "SELECT IF(ISNULL(MAX(idEtapa)),1, MAX(idEtapa) + 1) AS etapa FROM contenidoetapa WHERE idContenido = " + idContenido;
        int numeroEtapa = 0;
        try{
            contEtapaDAO.conectar();
            List<Map<String, Object>> resultado = contEtapaDAO.consultaGenerica(sql);
            for(Map<String, Object>respuesta : resultado){
                numeroEtapa = Integer.parseInt(respuesta.get("etapa").toString());
            }
            final int n = numeroEtapa;
            contEtapaDAO.desconectar();
            EtapaDAO etapaDAO = new EtapaDAO();
            etapaDAO.conectar();
            etapas = etapaDAO.buscarTodos().stream().filter(p -> p.getIdEtapa() <= n).collect(Collectors.toList());
            etapaDAO.desconectar();
        }catch(RuntimeException e){
            contEtapaDAO.desconectar();
        }
    }

    public String getIdContenido() {
        return idContenido;
    }

    public void setIdContenido(String idContenido) {
        this.idContenido = idContenido;
    }
    
    
    
}
