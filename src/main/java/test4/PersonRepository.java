package test4;

interface PersonRepository {
    /**
     * Tìm kiếm một người trong database theo tên
     * @param name
     * @return
     */
    Person getPersonByName(String name) ;
}
