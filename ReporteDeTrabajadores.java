import java.util.Scanner;

public class ReporteDeTrabajadores {
    static class Chofer {
        String nombre;
        int horasTrabajadasLunes;
        int horasTrabajadasMartes;
        int horasTrabajadasMiercoles;
        int horasTrabajadasJueves;
        int horasTrabajadasViernes;
        int horasTrabajadasSabado;
        double sueldoPorHora;
        String diaDescanso;

        public Chofer(String nombre, int horasTrabajadasLunes, int horasTrabajadasMartes, int horasTrabajadasMiercoles, int horasTrabajadasJueves, int horasTrabajadasViernes, int horasTrabajadasSabado, double sueldoPorHora, String diaDescanso) {
            this.nombre = nombre;
            this.horasTrabajadasLunes = horasTrabajadasLunes;
            this.horasTrabajadasMartes = horasTrabajadasMartes;
            this.horasTrabajadasMiercoles = horasTrabajadasMiercoles;
            this.horasTrabajadasJueves = horasTrabajadasJueves;
            this.horasTrabajadasViernes = horasTrabajadasViernes;
            this.horasTrabajadasSabado = horasTrabajadasSabado;
            this.sueldoPorHora = sueldoPorHora;
            this.diaDescanso = diaDescanso;
        }
    }

    public static void main(String[] args) {
        Scanner bun = new Scanner(System.in);
        double totalPagos = 0;
        String choferMasHorasLunes = "";
        int maxHorasLunes = 0;
        String[] nombres = new String[5];
        int[] totalHorasTrabajadas = new int[5];
        double[] sueldoSemanal = new double[5];

       

        for (int h = 0; h < 5; h++) {
            System.out.print("Ingrese el nombre del chofer " + (h + 1) + ": ");
            String nombre = bun.next();
            System.out.print("Ingrese las horas trabajadas el lunes: ");
            int horasTrabajadasLunes = bun.nextInt();
            System.out.print("Ingrese las horas trabajadas el martes: ");
            int horasTrabajadasMartes = bun.nextInt();
            System.out.print("Ingrese las horas trabajadas el miércoles: ");
            int horasTrabajadasMiercoles = bun.nextInt();
            System.out.print("Ingrese las horas trabajadas el jueves: ");
            int horasTrabajadasJueves = bun.nextInt();
            System.out.print("Ingrese las horas trabajadas el viernes: ");
            int horasTrabajadasViernes = bun.nextInt();
            System.out.print("Ingrese las horas trabajadas el sábado: ");
            int horasTrabajadasSabado = bun.nextInt();
            System.out.print("Ingrese el sueldo por hora: ");
            double sueldoPorHora = bun.nextDouble();
            bun.nextLine();
            System.out.print("Ingrese el día de descanso (lunes, martes, miércoles, jueves, viernes, sábado): ");
            String diaDescanso = bun.nextLine().toLowerCase();

            Chofer chofer = new Chofer(nombre, horasTrabajadasLunes, horasTrabajadasMartes, horasTrabajadasMiercoles, horasTrabajadasJueves, horasTrabajadasViernes, horasTrabajadasSabado, sueldoPorHora, diaDescanso);

            int totalHorasTrabajadasIndividual = 0;
            
            switch (diaDescanso) {
                case "lunes":
                    totalHorasTrabajadasIndividual = horasTrabajadasMartes + horasTrabajadasMiercoles + horasTrabajadasJueves + horasTrabajadasViernes + horasTrabajadasSabado;
                    break;
                case "martes":
                    totalHorasTrabajadasIndividual = horasTrabajadasLunes + horasTrabajadasMiercoles + horasTrabajadasJueves + horasTrabajadasViernes + horasTrabajadasSabado;
                    break;
                case "miércoles":
                case "miercoles":
                    totalHorasTrabajadasIndividual = horasTrabajadasLunes + horasTrabajadasMartes + horasTrabajadasJueves + horasTrabajadasViernes + horasTrabajadasSabado;
                    break;
                case "jueves":
                    totalHorasTrabajadasIndividual = horasTrabajadasLunes + horasTrabajadasMartes + horasTrabajadasMiercoles + horasTrabajadasViernes + horasTrabajadasSabado;
                    break;
                case "viernes":
                    totalHorasTrabajadasIndividual = horasTrabajadasLunes + horasTrabajadasMartes + horasTrabajadasMiercoles + horasTrabajadasJueves + horasTrabajadasSabado;
                    break;
                case "sábado":
                case "sabado":
                    totalHorasTrabajadasIndividual = horasTrabajadasLunes + horasTrabajadasMartes + horasTrabajadasMiercoles + horasTrabajadasJueves + horasTrabajadasViernes;
                    break;
            }

            totalHorasTrabajadas[h] = totalHorasTrabajadasIndividual;
            sueldoSemanal[h] = totalHorasTrabajadasIndividual * sueldoPorHora;
            totalPagos += sueldoSemanal[h];
            nombres[h] = nombre;

            if (horasTrabajadasLunes > maxHorasLunes) {
                maxHorasLunes = horasTrabajadasLunes;
                choferMasHorasLunes = nombre;
            }
        }
        
        System.out.println("Reporte de choferes");
        System.out.println("+-----------------------+-------------------------+-----------------------+");
        System.out.println("|        Nombre         |  Total Horas Trabajadas |  Sueldo Semanal       |");
        System.out.println("+-----------------------+-------------------------+-----------------------+");
        
        for (int h = 0; h < 5; h++) {
            System.out.printf("| %-21s | %-23d | %-21.2f |\n", nombres[h], totalHorasTrabajadas[h], sueldoSemanal[h]);
        }

        System.out.println("+-----------------------+-------------------------+-----------------------+");
        System.out.println("Total que la empresa pagará: " + totalPagos);
        System.out.println("Chofer que labora más horas el lunes: " + choferMasHorasLunes);
    }
}