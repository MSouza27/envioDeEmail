import enviando.email.ObjetoEnviaEmail;

public class ServiceEmail {

    @org.junit.Test
    public void testeEmail() throws Exception {

        StringBuilder stringBuilderTextoEmail = new StringBuilder();

        stringBuilderTextoEmail.append("<a href=\"https://www.github.com/MSouza27\"><img width=100% src=\"https://capsule-render.vercel.app/api?type=waving&color=1451da&height=120&section=header\"/></a>");
        stringBuilderTextoEmail.append("<h2 align=\"center\">Olá, sou Magno Souza! 👋🏻</h2>");
        stringBuilderTextoEmail.append("🌍 Apaixonado por Tecnologia<br/>");
        stringBuilderTextoEmail.append("🧑🏻‍💻 Desenvolvedor Back-End<br/>");
        stringBuilderTextoEmail.append("🎓 Cursando a transição para a área de TI<br/>");
        stringBuilderTextoEmail.append("⚡ Gosto de desafios, soluções criativas e estou sempre em busca de novos aprendizados.<br/><br/>");

        stringBuilderTextoEmail.append("<h2 align=\"center\">📫 Conecte-se comigo!</h2>");
        stringBuilderTextoEmail.append("<div align=\"center\">");
        stringBuilderTextoEmail.append("<a href=\"https://github.com/MSouza27\"><img src=\"https://img.shields.io/badge/github-1451da?style=for-the-badge&logo=github&logoColor=white\" alt=\"github\"/></a>");
        stringBuilderTextoEmail.append("<a href=\"https://www.linkedin.com/in/magno-souza-dos-santos/\"><img src=\"https://img.shields.io/badge/linkedin-1451da?style=for-the-badge&logo=linkedin&logoColor=white\" alt=\"linkedin\" /></a>");
        stringBuilderTextoEmail.append("<a href=\"https://instagram.com/magno1988\" target=\"_blank\"><img src=\"https://img.shields.io/badge/Instagram-1451da?style=for-the-badge&logo=Instagram&logoColor=white\" alt=\"instagram\"/></a>");
        stringBuilderTextoEmail.append("</div><br/>");

        stringBuilderTextoEmail.append("<h2 align=\"center\">🐙 GitHub Stats</h2>");
        stringBuilderTextoEmail.append("<div align=\"center\">");
        stringBuilderTextoEmail.append("<img src=\"https://github-profile-summary-cards.vercel.app/api/cards/profile-details?username=MSouza27&theme=github_dark\">");
        stringBuilderTextoEmail.append("<img src=\"https://github-profile-summary-cards.vercel.app/api/cards/stats?username=MSouza27&theme=github_dark\">");
        stringBuilderTextoEmail.append("<img src=\"https://github-profile-summary-cards.vercel.app/api/cards/repos-per-language?username=MSouza27&theme=github_dark\">");
        stringBuilderTextoEmail.append("<img src=\"https://github-profile-summary-cards.vercel.app/api/cards/most-commit-language?username=MSouza27&theme=github_dark\">");
        stringBuilderTextoEmail.append("</div><br/>");

        stringBuilderTextoEmail.append("<div align=\"center\">Made by 👽 <a href=\"https://github.com/MSouza27\">Magno Souza</a>.</div>");

        stringBuilderTextoEmail.append("<a href=\"https://github.com/MSouza27\"><img width=100% src=\"https://capsule-render.vercel.app/api?type=waving&color=1451da&height=120&section=footer\"/></a>");

        ObjetoEnviaEmail envio = new ObjetoEnviaEmail(
                "magnoemailjava@gmail.com",
                "Magno Souza",
                "Meu Portfólio - Magno Souza",
                stringBuilderTextoEmail.toString()
        );

        envio.enviarEmailAnexo(true);
    }
}
