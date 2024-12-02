package Main;

public class StudentDetails extends StudentInfo{
    
        private String sex;
        private String phoneNumber;
        private String address;
        private String birthDate;
        private String placeOfBirth;
        private String email;
        private String schoolYear;
        private String gradeLevel;
        public StudentDetails(String lastName, String firstName, String middleName, int age, String sex, String phoneNumber, String address, String birthDate, String email, String schoolYear , String gradeLevel) {
            super(lastName, firstName, middleName, age); 
            this.sex = sex;
            this.phoneNumber = phoneNumber;
            this.address = address;
            this.birthDate = birthDate;
            this.placeOfBirth = placeOfBirth;
            this.email = email;
            this.schoolYear = schoolYear;
            this.gradeLevel = gradeLevel;
        }
        public String getGradeLevel() {
            return gradeLevel;
        }
        public String getSchoolYear() {
            return schoolYear;
        }
        public String getEmail() {
            return email;
        }
        public void setSex(String sex) {
            this.sex = sex;
        }
        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }
        public void setAddress(String address) {
            this.address = address;
        }
        public void setBirthDate(String birthDate) {
            this.birthDate = birthDate;
        }
        public void setPlaceOfBirth(String placeOfBirth) {
            this.placeOfBirth = placeOfBirth;
        }
        public String getSex() {
            return sex;
        }
        public String getPhoneNumber() {
            return phoneNumber;
        }
        public String getAddress() {
            return address;
        }
        public String getBirthDate() {
            return birthDate;
        }
        public String getPlaceOfBirth() {
            return birthDate;
        }
}