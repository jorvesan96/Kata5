package kata5;

class People {
    private String name;
    private String apellidos;
    private String departamento;

    public People(String name, String apellidos, String departamento) {
        this.name = name;
        this.apellidos = apellidos;
        this.departamento = departamento;
    }

    public String getName() {
        return name;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDepartamento() {
        return departamento;
    }
    
    

}
