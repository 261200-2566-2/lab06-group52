public class sword implements accessories{

    /* Obtains a specific statistic of sword for a Human character.
     *
     * @param a Human character for which the statistic is obtained.
     * @return The specific statistic value of sword for the Human character when equipped.
     */
    @Override
    public double getstat(human a){
        double stat=20;
        return stat;
    }

    /* Obtains a specific statistic of sword for an Undead character.
     *
     * @param an Undead character for which the statistic is obtained.
     * @return The specific statistic value of sword for the Undead character when equipped.
     */
    @Override
    public double getstat(undead a){
        double stat=10;
        return stat;
    }

}//เป็นfunctionที่มีinputเป็นobject class humanและundead มีoutputเป็นค่าของstatที่เปลี่ยนแปลง เอาไว้เรียกใช้ตอนequip โดยหากใส่swordให้humanจะได้รับattackที่มากกว่าใส่ให้undead
