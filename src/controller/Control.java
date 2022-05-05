package controller;

import dao.AlunoExameDAOImplement;
import dao.ProfessorDAOImplement;
import dao.ResidenciaDAOImplement;
import dao.AulaDAOImplement;
import dao.PagamentoDAOImplement;
import dao.AlunoAulaDAOImplement;
import dao.MunicipioDAOImplement;
import dao.InstructorDAOImplement;
import dao.ProvinciaDAOImplement;
import dao.FuncionarioDAOImplement;
import dao.PessoaDAOImplement;
import dao.TipoDAOImplement;
import dao.BairroDAOImplement;
import dao.TipoTransporteDAOImplement;
import dao.TransporteDAOImplement;
import dao.TipoInscricaoDAOImplement;
import dao.AlunoDAOImplement;
import dao.BussinessException;
import dao.CargoDAOImplement;
import dao.CategoriaDAOImplement;
import dao.ExameDAOImplement;
import dao.InscricaoDAOImplement;

/**
 *
 * @author aaliagab generate
 */
public class Control {

    private AlunoExameDAOImplement AlunoExameDAO;
    private ProfessorDAOImplement ProfessorDAO;
    private ResidenciaDAOImplement ResidenciaDAO;
    private AulaDAOImplement AulaDAO;
    private PagamentoDAOImplement PagamentoDAO;
    private AlunoAulaDAOImplement AlunoAulaDAO;
    private MunicipioDAOImplement MunicipioDAO;
    private InstructorDAOImplement InstructorDAO;
    private ProvinciaDAOImplement ProvinciaDAO;
    private FuncionarioDAOImplement FuncionarioDAO;
    private PessoaDAOImplement PessoaDAO;
    private TipoDAOImplement TipoDAO;
    private BairroDAOImplement BairroDAO;
    private TipoTransporteDAOImplement TipoTransporteDAO;
    private TransporteDAOImplement TransporteDAO;
    private TipoInscricaoDAOImplement TipoInscricaoDAO;
    private AlunoDAOImplement AlunoDAO;
    private CargoDAOImplement CargoDAO;
    private CategoriaDAOImplement CategoriaDAO;
    private ExameDAOImplement ExameDAO;
    private InscricaoDAOImplement InscricaoDAO;
    private Toast msg;

    public Control() {
        AlunoExameDAO = new AlunoExameDAOImplement();
        ProfessorDAO = new ProfessorDAOImplement();
        ResidenciaDAO = new ResidenciaDAOImplement();
        AulaDAO = new AulaDAOImplement();
        PagamentoDAO = new PagamentoDAOImplement();
        AlunoAulaDAO = new AlunoAulaDAOImplement();
        MunicipioDAO = new MunicipioDAOImplement();
        InstructorDAO = new InstructorDAOImplement();
        ProvinciaDAO = new ProvinciaDAOImplement();
        FuncionarioDAO = new FuncionarioDAOImplement();
        PessoaDAO = new PessoaDAOImplement();
        TipoDAO = new TipoDAOImplement();
        BairroDAO = new BairroDAOImplement();
        TipoTransporteDAO = new TipoTransporteDAOImplement();
        TransporteDAO = new TransporteDAOImplement();
        TipoInscricaoDAO = new TipoInscricaoDAOImplement();
        AlunoDAO = new AlunoDAOImplement();
        CargoDAO = new CargoDAOImplement();
        CategoriaDAO = new CategoriaDAOImplement();
        ExameDAO = new ExameDAOImplement();
        InscricaoDAO = new InscricaoDAOImplement();
    }

    public AlunoExameDAOImplement getAlunoExameDAO() {
        return AlunoExameDAO;
    }

    public ProfessorDAOImplement getProfessorDAO() {
        return ProfessorDAO;
    }

    public ResidenciaDAOImplement getResidenciaDAO() {
        return ResidenciaDAO;
    }

    public AulaDAOImplement getAulaDAO() {
        return AulaDAO;
    }

    public PagamentoDAOImplement getPagamentoDAO() {
        return PagamentoDAO;
    }

    public AlunoAulaDAOImplement getAlunoAulaDAO() {
        return AlunoAulaDAO;
    }

    public MunicipioDAOImplement getMunicipioDAO() {
        return MunicipioDAO;
    }

    public InstructorDAOImplement getInstructorDAO() {
        return InstructorDAO;
    }

    public ProvinciaDAOImplement getProvinciaDAO() {
        return ProvinciaDAO;
    }

    public FuncionarioDAOImplement getFuncionarioDAO() {
        return FuncionarioDAO;
    }

    public PessoaDAOImplement getPessoaDAO() {
        return PessoaDAO;
    }

    public TipoDAOImplement getTipoDAO() {
        return TipoDAO;
    }

    public BairroDAOImplement getBairroDAO() {
        return BairroDAO;
    }

    public TipoTransporteDAOImplement getTipoTransporteDAO() {
        return TipoTransporteDAO;
    }

    public TransporteDAOImplement getTransporteDAO() {
        return TransporteDAO;
    }

    public TipoInscricaoDAOImplement getTipoInscricaoDAO() {
        return TipoInscricaoDAO;
    }

    public AlunoDAOImplement getAlunoDAO() {
        return AlunoDAO;
    }

    public CargoDAOImplement getCargoDAO() {
        return CargoDAO;
    }

    public CategoriaDAOImplement getCategoriaDAO() {
        return CategoriaDAO;
    }

    public ExameDAOImplement getExameDAO() {
        return ExameDAO;
    }

    public InscricaoDAOImplement getInscricaoDAO() {
        return InscricaoDAO;
    }

    public Toast getMsg() {
        return msg;
    }

    public void messageFieldEmpty() {
        msg = new Toast("Você deve preencher todos os campos do formulário", 2000);
        msg.showToast();
    }

    public void messageErro(Exception e) {
        msg = new Toast(e.getMessage(), 2000);
        msg.showToast();
    }

    public void messageErroBussiness(BussinessException e) {
        msg = new Toast(e.getMessage(), 2000);
        msg.showToast();
    }

    public void messageNomeUsuario() {
        msg = new Toast("Você tem que escrever o nome de usuário", 2000);
        msg.showToast();
    }

    public void messageSenhaUsuario() {
        msg = new Toast("Você tem que escrever a senha de usuário", 2000);
        msg.showToast();
    }

    public void messageUsuarioNaoCorreto() {
        msg = new Toast("O username de usuário inserido não está correto", 2000);
        msg.showToast();
    }

    public void messageSenhaNaoCorreta() {
        msg = new Toast("A senha de usuário inserida não está correta", 2000);
        msg.showToast();
    }

    public void messageUmaLinha() {
        msg = new Toast("Você só pode selecionar uma linha", 2000);
        msg.showToast();
    }

    public void messageLinhasExcluir() {
        msg = new Toast("Você tem que fazer uma seleção das linhas a excluir", 2000);
        msg.showToast();
    }

    public void messageErroEmail() {
        msg = new Toast("O campo de email não é correto", 2000);
        msg.showToast();
    }

    public void messageSelecaoEditar() {
        msg = new Toast("Você tem que fazer uma seleção para editar", 2000);
        msg.showToast();
    }

    public void messageSelecaoRelatorio() {
        msg = new Toast("Você tem que fazer uma seleção para gerar relatório", 2000);
        msg.showToast();
    }

    public void messageOperacaoSucesso() {
        msg = new Toast("Operação feita com sucesso!!", 2000);
        msg.showToast();
    }
}
