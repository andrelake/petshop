package com.andre.petshop.utils;

import com.andre.petshop.domain.*;
import com.andre.petshop.domain.enums.SituacaoPagamentoEnum;
import com.andre.petshop.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

@Component
public class PopulaDados {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private RacaRepository racaRepository;

    @Autowired
    private EspecieRepository especieRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ServicoRepository servicoRepository;

    @Autowired
    private PagamentoRepository pagamentoRepository;

    public void cadastrar() throws ParseException {
        Categoria c1 = new Categoria(null, "Alimento");
        Categoria c2 = new Categoria(null, "Remédio");
        Categoria c3 = new Categoria(null, "Cosmético");

        Produto p1 = new Produto(null, "Ração", 100.0);
        Produto p2 = new Produto(null, "Sache", 80.0);
        Produto p3 = new Produto(null, "Vermífugo", 20.0);
        Produto p4 = new Produto(null, "Shampoo", 50.0);

        c1.getProdutosList().addAll(Arrays.asList(p1, p2));
        c2.getProdutosList().addAll(Arrays.asList(p3, p4));
        c3.getProdutosList().addAll(Arrays.asList(p4));

        p1.getCategoriasList().add(c1);
        p2.getCategoriasList().add(c1);
        p3.getCategoriasList().add(c2);
        p4.getCategoriasList().addAll(Arrays.asList(c2, c3));

        categoriaRepository.saveAll(Arrays.asList(c1, c2,c3));
        produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4));

        Especie s1 = new Especie(null, "Cachorro");
        Especie s2 = new Especie(null, "Gato");

        Raca rac1 = new Raca(null, "Shitzu");
        Raca rac2 = new Raca(null, "Akita");
        Raca rac3 = new Raca(null, "Persa");

        Pet pet1 = new Pet(null, "John", s1, rac1, 6);
        Pet pet2 = new Pet(null, "Hana", s1, rac2, 5);
        Pet pet3 = new Pet(null, "Mewth", s2, rac3, 8);

        especieRepository.saveAll(Arrays.asList(s1, s2));
        racaRepository.saveAll(Arrays.asList(rac1, rac2, rac3));
        petRepository.saveAll(Arrays.asList(pet1, pet2, pet3));

        Estado est1 = new Estado(null, "MG");
        Estado est2 = new Estado(null, "SP");

        Cidade cid1 = new Cidade(null, "Belo Horizonte", est1);
        Cidade cid2 = new Cidade(null, "São Paulo", est2);

        est1.getCidadeList().add(cid1);
        est2.getCidadeList().add(cid2);

        estadoRepository.saveAll(Arrays.asList(est1, est2));
        cidadeRepository.saveAll(Arrays.asList(cid1, cid2));

        Cliente clt1 = new Cliente(null, "Jose", "jose@gmail.com", "111.111.111-11", "Fisica");
        Cliente clt2 = new Cliente(null, "Pedro", "pedro@gmail.com", "333.333.111-11", "Fisica");
        clt1.getTelefone().addAll(Arrays.asList("1111-1111", "9999-9999"));
        clt2.getTelefone().addAll(Arrays.asList("9911-1111", "9999-1111"));

        Funcionario f1 = new Funcionario(null, "Maria", "maria@gmail.com", "222.222.222-22", "Caixa");
        Funcionario f2 = new Funcionario(null, "Ana", "ana@gmail.com", "444.222.444-22", "Operacional");
        f1.getTelefone().addAll(Arrays.asList("3223-3311", "9090-0123", "9123-0932"));
        f2.getTelefone().addAll(Arrays.asList("3113-3999", "9090-0333", "9123-0932"));

        Endereco end1 = new Endereco(null, "Rua Tupis", "500", "Apto 101", "Pindorama", "30111222", clt1, cid1);
        Endereco end2 = new Endereco(null, "Av Tamoios", "100", "Casa", "Oca", "3968000", f1, cid2);
        Endereco end3 = new Endereco(null, "Rua Aranãs", "50", "Apto 201", "Centro", "01153000", f1, cid2);

        pessoaRepository.saveAll(Arrays.asList(clt1, clt2, f1, f2));
        enderecoRepository.saveAll(Arrays.asList(end1, end2, end3));


        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Servico sv1 = new Servico(
                null, sdf.parse("02/09/2021 09:00"), sdf.parse("02/09/2021 12:00"), "Tosa", clt1, f1, pet1);
        Servico sv2 = new Servico(
                null, sdf.parse("03/09/2021 12:00"), sdf.parse("04/09/2021 12:00"), "Hotel", clt1, f1, pet2);
        Servico sv3 = new Servico(
                null, sdf.parse("05/09/2021 15:00"), sdf.parse("05/09/2021 16:00"), "Vermifugação", clt1, f2, pet3);

        Pagamento pg1 = new PagCartao(null, 60.00, SituacaoPagamentoEnum.QUITADO, sv2, 1);
        sv2.setPagamento(pg1);
        Pagamento pg2 = new PagDinheiro(null, 100.00, SituacaoPagamentoEnum.PENDENTE, sv1, sdf.parse("02/09/2021 09:00"), 0.0);
        sv1.setPagamento(pg2);
        Pagamento pg3 = new PagDinheiro(null, 100.00, SituacaoPagamentoEnum.QUITADO, sv3, sdf.parse("05/09/2021 16:00"), 0.0);
        sv3.setPagamento(pg3);

        clt1.getServicoList().addAll(Arrays.asList(sv1, sv2));
        f1.getServicoList().addAll(Arrays.asList(sv1, sv2));

        sv2.getProdutoList().addAll(Arrays.asList(p1, p2, p4));
        sv3.getProdutoList().addAll(List.of(p3));

        servicoRepository.saveAll(Arrays.asList(sv1, sv2, sv3));
        pagamentoRepository.saveAll(Arrays.asList(pg1, pg2, pg3));
    }
}
