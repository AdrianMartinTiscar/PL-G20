/* Generated By:JavaCC: Do not edit this line. AnalizadorSintacticoTiny1TokenManager.java */
package ASintTiny1;

public class AnalizadorSintacticoTiny1TokenManager implements AnalizadorSintacticoTiny1Constants
{
  public  java.io.PrintStream debugStream = System.out;
  public  void setDebugStream(java.io.PrintStream ds) { debugStream = ds; }
private final int jjStopStringLiteralDfa_0(int pos, long active0, long active1)
{
   switch (pos)
   {
      case 0:
         if ((active0 & 0x8001800000000000L) != 0L)
            return 9;
         if ((active0 & 0xfa3ffe133f8000L) != 0L)
         {
            jjmatchedKind = 10;
            return 7;
         }
         return -1;
      case 1:
         if ((active0 & 0xfa3ffe133f8000L) != 0L)
         {
            jjmatchedKind = 10;
            jjmatchedPos = 1;
            return 7;
         }
         return -1;
      case 2:
         if ((active0 & 0x7a3bbc123f8000L) != 0L)
         {
            jjmatchedKind = 10;
            jjmatchedPos = 2;
            return 7;
         }
         return -1;
      case 3:
         if ((active0 & 0x3833bc123d0000L) != 0L)
         {
            jjmatchedKind = 10;
            jjmatchedPos = 3;
            return 7;
         }
         return -1;
      case 4:
         if ((active0 & 0x1012a812300000L) != 0L)
         {
            jjmatchedKind = 10;
            jjmatchedPos = 4;
            return 7;
         }
         return -1;
      case 5:
         if ((active0 & 0x108012100000L) != 0L)
         {
            jjmatchedKind = 10;
            jjmatchedPos = 5;
            return 7;
         }
         return -1;
      case 6:
         if ((active0 & 0x8010000000L) != 0L)
         {
            jjmatchedKind = 10;
            jjmatchedPos = 6;
            return 7;
         }
         return -1;
      default :
         return -1;
   }
}
private final int jjStartNfa_0(int pos, long active0, long active1)
{
   return jjMoveNfa_0(jjStopStringLiteralDfa_0(pos, active0, active1), pos + 1);
}
private final int jjStopAtPos(int pos, int kind)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   return pos + 1;
}
private final int jjStartNfaWithStates_0(int pos, int kind, int state)
{
   jjmatchedKind = kind;
   jjmatchedPos = pos;
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) { return pos + 1; }
   return jjMoveNfa_0(state, pos + 1);
}
private final int jjMoveStringLiteralDfa0_0()
{
   switch(curChar)
   {
      case 33:
         return jjMoveStringLiteralDfa1_0(0x800000000000000L);
      case 37:
         return jjStopAtPos(0, 61);
      case 38:
         jjmatchedKind = 31;
         return jjMoveStringLiteralDfa1_0(0x2000L);
      case 40:
         return jjStopAtPos(0, 29);
      case 41:
         return jjStopAtPos(0, 30);
      case 42:
         return jjStopAtPos(0, 50);
      case 43:
         return jjStartNfaWithStates_0(0, 47, 9);
      case 44:
         return jjStopAtPos(0, 46);
      case 45:
         jjmatchedKind = 48;
         return jjMoveStringLiteralDfa1_0(0x8000000000000000L);
      case 46:
         return jjStopAtPos(0, 62);
      case 47:
         return jjStopAtPos(0, 60);
      case 59:
         return jjStopAtPos(0, 14);
      case 60:
         return jjStopAtPos(0, 56);
      case 61:
         jjmatchedKind = 32;
         return jjMoveStringLiteralDfa1_0(0x400000000000000L);
      case 62:
         return jjStopAtPos(0, 57);
      case 91:
         return jjStopAtPos(0, 22);
      case 93:
         return jjStopAtPos(0, 23);
      case 97:
         return jjMoveStringLiteralDfa1_0(0x40000000200000L);
      case 98:
         return jjMoveStringLiteralDfa1_0(0x40000L);
      case 99:
         return jjMoveStringLiteralDfa1_0(0x200000000000L);
      case 100:
         return jjMoveStringLiteralDfa1_0(0x104000000000L);
      case 101:
         return jjMoveStringLiteralDfa1_0(0x9800000000L);
      case 102:
         return jjMoveStringLiteralDfa1_0(0x10000000000000L);
      case 105:
         return jjMoveStringLiteralDfa1_0(0x200020000L);
      case 110:
         return jjMoveStringLiteralDfa1_0(0x220c0000000000L);
      case 111:
         return jjMoveStringLiteralDfa1_0(0x80000001000000L);
      case 112:
         return jjMoveStringLiteralDfa1_0(0x10010000L);
      case 114:
         return jjMoveStringLiteralDfa1_0(0x10002080000L);
      case 115:
         return jjMoveStringLiteralDfa1_0(0x100000L);
      case 116:
         return jjMoveStringLiteralDfa1_0(0x8000400000000L);
      case 118:
         return jjMoveStringLiteralDfa1_0(0x8000L);
      case 119:
         return jjMoveStringLiteralDfa1_0(0x22000000000L);
      case 123:
         return jjStopAtPos(0, 26);
      case 125:
         return jjStopAtPos(0, 27);
      default :
         return jjMoveNfa_0(0, 0);
   }
}
private final int jjMoveStringLiteralDfa1_0(long active0)
{
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(0, active0, 0L);
      return 1;
   }
   switch(curChar)
   {
      case 38:
         if ((active0 & 0x2000L) != 0L)
            return jjStopAtPos(1, 13);
         break;
      case 61:
         if ((active0 & 0x400000000000000L) != 0L)
            return jjStopAtPos(1, 58);
         else if ((active0 & 0x800000000000000L) != 0L)
            return jjStopAtPos(1, 59);
         break;
      case 62:
         if ((active0 & 0x8000000000000000L) != 0L)
            return jjStopAtPos(1, 63);
         break;
      case 97:
         return jjMoveStringLiteralDfa2_0(active0, 0x10200000008000L);
      case 101:
         return jjMoveStringLiteralDfa2_0(active0, 0x190002080000L);
      case 102:
         if ((active0 & 0x1000000L) != 0L)
            return jjStartNfaWithStates_0(1, 10, 7);
         else if ((active0 & 0x200000000L) != 0L)
            return jjStartNfaWithStates_0(1, 10, 7);
         break;
      case 104:
         return jjMoveStringLiteralDfa2_0(active0, 0x2400000000L);
      case 108:
         if ((active0 & 0x40000000000L) != 0L)
            return jjStartNfaWithStates_0(1, 10, 7);
         return jjMoveStringLiteralDfa2_0(active0, 0x1000000000L);
      case 110:
         return jjMoveStringLiteralDfa2_0(active0, 0x40008800020000L);
      case 111:
         if ((active0 & 0x4000000000L) != 0L)
            return jjStartNfaWithStates_0(1, 10, 7);
         return jjMoveStringLiteralDfa2_0(active0, 0x2000010040000L);
      case 114:
         if ((active0 & 0x80000000000000L) != 0L)
            return jjStartNfaWithStates_0(1, 10, 7);
         return jjMoveStringLiteralDfa2_0(active0, 0x8020000210000L);
      case 116:
         return jjMoveStringLiteralDfa2_0(active0, 0x100000L);
      case 117:
         return jjMoveStringLiteralDfa2_0(active0, 0x20000000000000L);
      default :
         break;
   }
   return jjStartNfa_0(0, active0, 0L);
}
private final int jjMoveStringLiteralDfa2_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(0, old0, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(1, active0, 0L);
      return 2;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa3_0(active0, 0x10000080000L);
      case 99:
         return jjMoveStringLiteralDfa3_0(active0, 0x2000000L);
      case 100:
         if ((active0 & 0x40000000000000L) != 0L)
            return jjStartNfaWithStates_0(2, 10, 7);
         return jjMoveStringLiteralDfa3_0(active0, 0x8800000000L);
      case 101:
         return jjMoveStringLiteralDfa3_0(active0, 0x400000000L);
      case 105:
         return jjMoveStringLiteralDfa3_0(active0, 0x22010000000L);
      case 108:
         return jjMoveStringLiteralDfa3_0(active0, 0x30300000000000L);
      case 111:
         return jjMoveStringLiteralDfa3_0(active0, 0x50000L);
      case 114:
         if ((active0 & 0x8000L) != 0L)
            return jjStartNfaWithStates_0(2, 10, 7);
         return jjMoveStringLiteralDfa3_0(active0, 0x300000L);
      case 115:
         return jjMoveStringLiteralDfa3_0(active0, 0x1000000000L);
      case 116:
         if ((active0 & 0x20000L) != 0L)
            return jjStartNfaWithStates_0(2, 10, 7);
         else if ((active0 & 0x2000000000000L) != 0L)
            return jjStartNfaWithStates_0(2, 10, 7);
         break;
      case 117:
         return jjMoveStringLiteralDfa3_0(active0, 0x8000000000000L);
      case 119:
         if ((active0 & 0x80000000000L) != 0L)
            return jjStartNfaWithStates_0(2, 10, 7);
         break;
      default :
         break;
   }
   return jjStartNfa_0(1, active0, 0L);
}
private final int jjMoveStringLiteralDfa3_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(1, old0, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(2, active0, 0L);
      return 3;
   }
   switch(curChar)
   {
      case 97:
         return jjMoveStringLiteralDfa4_0(active0, 0x200000L);
      case 99:
         if ((active0 & 0x10000L) != 0L)
            return jjStartNfaWithStates_0(3, 10, 7);
         break;
      case 100:
         if ((active0 & 0x10000000000L) != 0L)
            return jjStartNfaWithStates_0(3, 10, 7);
         break;
      case 101:
         if ((active0 & 0x1000000000L) != 0L)
            return jjStartNfaWithStates_0(3, 10, 7);
         else if ((active0 & 0x8000000000000L) != 0L)
            return jjStartNfaWithStates_0(3, 10, 7);
         return jjMoveStringLiteralDfa4_0(active0, 0x100000000000L);
      case 105:
         return jjMoveStringLiteralDfa4_0(active0, 0x800100000L);
      case 108:
         if ((active0 & 0x40000L) != 0L)
            return jjStartNfaWithStates_0(3, 10, 7);
         else if ((active0 & 0x80000L) != 0L)
            return jjStartNfaWithStates_0(3, 10, 7);
         else if ((active0 & 0x200000000000L) != 0L)
            return jjStartNfaWithStates_0(3, 10, 7);
         else if ((active0 & 0x20000000000000L) != 0L)
            return jjStartNfaWithStates_0(3, 10, 7);
         return jjMoveStringLiteralDfa4_0(active0, 0x2000000000L);
      case 110:
         if ((active0 & 0x400000000L) != 0L)
            return jjStartNfaWithStates_0(3, 10, 7);
         return jjMoveStringLiteralDfa4_0(active0, 0x10000000L);
      case 111:
         return jjMoveStringLiteralDfa4_0(active0, 0x2000000L);
      case 115:
         return jjMoveStringLiteralDfa4_0(active0, 0x10000000000000L);
      case 116:
         return jjMoveStringLiteralDfa4_0(active0, 0x20000000000L);
      case 119:
         return jjMoveStringLiteralDfa4_0(active0, 0x8000000000L);
      default :
         break;
   }
   return jjStartNfa_0(2, active0, 0L);
}
private final int jjMoveStringLiteralDfa4_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(2, old0, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(3, active0, 0L);
      return 4;
   }
   switch(curChar)
   {
      case 101:
         if ((active0 & 0x2000000000L) != 0L)
            return jjStartNfaWithStates_0(4, 10, 7);
         else if ((active0 & 0x20000000000L) != 0L)
            return jjStartNfaWithStates_0(4, 10, 7);
         else if ((active0 & 0x10000000000000L) != 0L)
            return jjStartNfaWithStates_0(4, 10, 7);
         break;
      case 102:
         if ((active0 & 0x800000000L) != 0L)
            return jjStartNfaWithStates_0(4, 10, 7);
         break;
      case 104:
         return jjMoveStringLiteralDfa5_0(active0, 0x8000000000L);
      case 110:
         return jjMoveStringLiteralDfa5_0(active0, 0x100000L);
      case 114:
         return jjMoveStringLiteralDfa5_0(active0, 0x2000000L);
      case 116:
         return jjMoveStringLiteralDfa5_0(active0, 0x100010000000L);
      case 121:
         if ((active0 & 0x200000L) != 0L)
            return jjStartNfaWithStates_0(4, 10, 7);
         break;
      default :
         break;
   }
   return jjStartNfa_0(3, active0, 0L);
}
private final int jjMoveStringLiteralDfa5_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(3, old0, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(4, active0, 0L);
      return 5;
   }
   switch(curChar)
   {
      case 100:
         if ((active0 & 0x2000000L) != 0L)
            return jjStartNfaWithStates_0(5, 10, 7);
         break;
      case 101:
         if ((active0 & 0x100000000000L) != 0L)
            return jjStartNfaWithStates_0(5, 10, 7);
         return jjMoveStringLiteralDfa6_0(active0, 0x10000000L);
      case 103:
         if ((active0 & 0x100000L) != 0L)
            return jjStartNfaWithStates_0(5, 10, 7);
         break;
      case 105:
         return jjMoveStringLiteralDfa6_0(active0, 0x8000000000L);
      default :
         break;
   }
   return jjStartNfa_0(4, active0, 0L);
}
private final int jjMoveStringLiteralDfa6_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(4, old0, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(5, active0, 0L);
      return 6;
   }
   switch(curChar)
   {
      case 108:
         return jjMoveStringLiteralDfa7_0(active0, 0x8000000000L);
      case 114:
         if ((active0 & 0x10000000L) != 0L)
            return jjStartNfaWithStates_0(6, 10, 7);
         break;
      default :
         break;
   }
   return jjStartNfa_0(5, active0, 0L);
}
private final int jjMoveStringLiteralDfa7_0(long old0, long active0)
{
   if (((active0 &= old0)) == 0L)
      return jjStartNfa_0(5, old0, 0L);
   try { curChar = input_stream.readChar(); }
   catch(java.io.IOException e) {
      jjStopStringLiteralDfa_0(6, active0, 0L);
      return 7;
   }
   switch(curChar)
   {
      case 101:
         if ((active0 & 0x8000000000L) != 0L)
            return jjStartNfaWithStates_0(7, 10, 7);
         break;
      default :
         break;
   }
   return jjStartNfa_0(6, active0, 0L);
}
private final void jjCheckNAdd(int state)
{
   if (jjrounds[state] != jjround)
   {
      jjstateSet[jjnewStateCnt++] = state;
      jjrounds[state] = jjround;
   }
}
private final void jjAddStates(int start, int end)
{
   do {
      jjstateSet[jjnewStateCnt++] = jjnextStates[start];
   } while (start++ != end);
}
private final void jjCheckNAddTwoStates(int state1, int state2)
{
   jjCheckNAdd(state1);
   jjCheckNAdd(state2);
}
private final void jjCheckNAddStates(int start, int end)
{
   do {
      jjCheckNAdd(jjnextStates[start]);
   } while (start++ != end);
}
private final void jjCheckNAddStates(int start)
{
   jjCheckNAdd(jjnextStates[start]);
   jjCheckNAdd(jjnextStates[start + 1]);
}
static final long[] jjbitVec0 = {
   0x0L, 0x0L, 0xffffffffffffffffL, 0xffffffffffffffffL
};
private final int jjMoveNfa_0(int startState, int curPos)
{
   int[] nextStates;
   int startsAt = 0;
   jjnewStateCnt = 42;
   int i = 1;
   jjstateSet[0] = startState;
   int j, kind = 0x7fffffff;
   for (;;)
   {
      if (++jjround == 0x7fffffff)
         ReInitRounds();
      if (curChar < 64)
      {
         long l = 1L << curChar;
         MatchLoop: do
         {
            switch(jjstateSet[--i])
            {
               case 0:
                  if ((0x3fe000000000000L & l) != 0L)
                  {
                     if (kind > 11)
                        kind = 11;
                     jjCheckNAddStates(0, 2);
                  }
                  else if ((0x100002700L & l) != 0L)
                  {
                     if (kind > 1)
                        kind = 1;
                  }
                  else if ((0x280000000000L & l) != 0L)
                     jjAddStates(3, 6);
                  else if (curChar == 48)
                  {
                     if (kind > 11)
                        kind = 11;
                     jjCheckNAdd(14);
                  }
                  else if (curChar == 34)
                     jjCheckNAddTwoStates(4, 5);
                  else if (curChar == 35)
                  {
                     if (kind > 2)
                        kind = 2;
                     jjCheckNAdd(2);
                  }
                  break;
               case 9:
                  if ((0x3fe000000000000L & l) != 0L)
                     jjCheckNAddTwoStates(13, 14);
                  else if (curChar == 48)
                     jjCheckNAdd(14);
                  if ((0x3fe000000000000L & l) != 0L)
                  {
                     if (kind > 11)
                        kind = 11;
                     jjCheckNAdd(10);
                  }
                  else if (curChar == 48)
                  {
                     if (kind > 11)
                        kind = 11;
                  }
                  break;
               case 1:
                  if (curChar != 35)
                     break;
                  if (kind > 2)
                     kind = 2;
                  jjCheckNAdd(2);
                  break;
               case 2:
                  if ((0xfffffffffffffbffL & l) == 0L)
                     break;
                  if (kind > 2)
                     kind = 2;
                  jjCheckNAdd(2);
                  break;
               case 3:
                  if (curChar == 34)
                     jjCheckNAddTwoStates(4, 5);
                  break;
               case 4:
                  if ((0xffffffffffffdaffL & l) != 0L)
                     jjCheckNAddTwoStates(4, 5);
                  break;
               case 5:
                  if (curChar == 34 && kind > 9)
                     kind = 9;
                  break;
               case 7:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 10)
                     kind = 10;
                  jjstateSet[jjnewStateCnt++] = 7;
                  break;
               case 8:
                  if ((0x280000000000L & l) != 0L)
                     jjAddStates(3, 6);
                  break;
               case 10:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 11)
                     kind = 11;
                  jjCheckNAdd(10);
                  break;
               case 11:
                  if (curChar == 48 && kind > 11)
                     kind = 11;
                  break;
               case 12:
                  if ((0x3fe000000000000L & l) != 0L)
                     jjCheckNAddTwoStates(13, 14);
                  break;
               case 13:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddTwoStates(13, 14);
                  break;
               case 14:
                  if (curChar == 46)
                     jjAddStates(7, 11);
                  break;
               case 16:
                  if ((0x280000000000L & l) != 0L)
                     jjCheckNAddTwoStates(17, 19);
                  break;
               case 17:
                  if ((0x3fe000000000000L & l) == 0L)
                     break;
                  if (kind > 12)
                     kind = 12;
                  jjCheckNAdd(18);
                  break;
               case 18:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 12)
                     kind = 12;
                  jjCheckNAdd(18);
                  break;
               case 19:
                  if (curChar == 48 && kind > 12)
                     kind = 12;
                  break;
               case 21:
                  if ((0x280000000000L & l) != 0L)
                     jjCheckNAddTwoStates(22, 19);
                  break;
               case 22:
                  if ((0x3fe000000000000L & l) == 0L)
                     break;
                  if (kind > 12)
                     kind = 12;
                  jjCheckNAdd(23);
                  break;
               case 23:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 12)
                     kind = 12;
                  jjCheckNAdd(23);
                  break;
               case 24:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddStates(12, 15);
                  break;
               case 25:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddTwoStates(25, 26);
                  break;
               case 26:
                  if ((0x3fe000000000000L & l) != 0L)
                     jjCheckNAddTwoStates(27, 31);
                  break;
               case 28:
                  if ((0x280000000000L & l) != 0L)
                     jjCheckNAddTwoStates(29, 19);
                  break;
               case 29:
                  if ((0x3fe000000000000L & l) == 0L)
                     break;
                  if (kind > 12)
                     kind = 12;
                  jjCheckNAdd(30);
                  break;
               case 30:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 12)
                     kind = 12;
                  jjCheckNAdd(30);
                  break;
               case 32:
                  if ((0x280000000000L & l) != 0L)
                     jjCheckNAddTwoStates(33, 19);
                  break;
               case 33:
                  if ((0x3fe000000000000L & l) == 0L)
                     break;
                  if (kind > 12)
                     kind = 12;
                  jjCheckNAdd(34);
                  break;
               case 34:
                  if ((0x3ff000000000000L & l) == 0L)
                     break;
                  if (kind > 12)
                     kind = 12;
                  jjCheckNAdd(34);
                  break;
               case 35:
                  if ((0x3ff000000000000L & l) != 0L)
                     jjCheckNAddTwoStates(35, 36);
                  break;
               case 36:
                  if ((0x3fe000000000000L & l) != 0L && kind > 12)
                     kind = 12;
                  break;
               case 37:
                  if ((0x3fe000000000000L & l) == 0L)
                     break;
                  if (kind > 12)
                     kind = 12;
                  jjCheckNAddTwoStates(27, 31);
                  break;
               case 38:
                  if (curChar != 48)
                     break;
                  if (kind > 12)
                     kind = 12;
                  jjCheckNAddTwoStates(27, 31);
                  break;
               case 39:
                  if (curChar == 48)
                     jjCheckNAdd(14);
                  break;
               case 40:
                  if ((0x3fe000000000000L & l) == 0L)
                     break;
                  if (kind > 11)
                     kind = 11;
                  jjCheckNAddStates(0, 2);
                  break;
               case 41:
                  if (curChar != 48)
                     break;
                  if (kind > 11)
                     kind = 11;
                  jjCheckNAdd(14);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else if (curChar < 128)
      {
         long l = 1L << (curChar & 077);
         MatchLoop: do
         {
            switch(jjstateSet[--i])
            {
               case 0:
                  if ((0x7fffffe07fffffeL & l) == 0L)
                     break;
                  if (kind > 10)
                     kind = 10;
                  jjCheckNAdd(7);
                  break;
               case 2:
                  if (kind > 2)
                     kind = 2;
                  jjstateSet[jjnewStateCnt++] = 2;
                  break;
               case 4:
                  jjAddStates(16, 17);
                  break;
               case 7:
                  if ((0x7fffffe87fffffeL & l) == 0L)
                     break;
                  if (kind > 10)
                     kind = 10;
                  jjCheckNAdd(7);
                  break;
               case 15:
                  if (curChar == 69)
                     jjCheckNAddStates(18, 20);
                  break;
               case 20:
                  if (curChar == 101)
                     jjCheckNAddStates(21, 23);
                  break;
               case 27:
                  if (curChar == 101)
                     jjCheckNAddStates(24, 26);
                  break;
               case 31:
                  if (curChar == 69)
                     jjCheckNAddStates(27, 29);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      else
      {
         int i2 = (curChar & 0xff) >> 6;
         long l2 = 1L << (curChar & 077);
         MatchLoop: do
         {
            switch(jjstateSet[--i])
            {
               case 2:
                  if ((jjbitVec0[i2] & l2) == 0L)
                     break;
                  if (kind > 2)
                     kind = 2;
                  jjstateSet[jjnewStateCnt++] = 2;
                  break;
               case 4:
                  if ((jjbitVec0[i2] & l2) != 0L)
                     jjAddStates(16, 17);
                  break;
               default : break;
            }
         } while(i != startsAt);
      }
      if (kind != 0x7fffffff)
      {
         jjmatchedKind = kind;
         jjmatchedPos = curPos;
         kind = 0x7fffffff;
      }
      ++curPos;
      if ((i = jjnewStateCnt) == (startsAt = 42 - (jjnewStateCnt = startsAt)))
         return curPos;
      try { curChar = input_stream.readChar(); }
      catch(java.io.IOException e) { return curPos; }
   }
}
static final int[] jjnextStates = {
   10, 13, 14, 9, 11, 12, 39, 15, 20, 24, 37, 38, 25, 26, 35, 36, 
   4, 5, 16, 17, 19, 21, 22, 19, 28, 29, 19, 32, 33, 19, 
};
public static final String[] jjstrLiteralImages = {
"", null, null, null, null, null, null, null, null, null, null, null, null, 
"\46\46", "\73", "\166\141\162", "\160\162\157\143", "\151\156\164", "\142\157\157\154", 
"\162\145\141\154", "\163\164\162\151\156\147", "\141\162\162\141\171", "\133", "\135", 
"\157\146", "\162\145\143\157\162\144", "\173", "\175", "\160\157\151\156\164\145\162", 
"\50", "\51", "\46", "\75", "\151\146", "\164\150\145\156", "\145\156\144\151\146", 
"\145\154\163\145", "\167\150\151\154\145", "\144\157", "\145\156\144\167\150\151\154\145", 
"\162\145\141\144", "\167\162\151\164\145", "\156\154", "\156\145\167", 
"\144\145\154\145\164\145", "\143\141\154\154", "\54", "\53", "\55", "\156\157\164", "\52", 
"\164\162\165\145", "\146\141\154\163\145", "\156\165\154\154", "\141\156\144", "\157\162", "\74", 
"\76", "\75\75", "\41\75", "\57", "\45", "\56", "\55\76", };
public static final String[] lexStateNames = {
   "DEFAULT", 
};
static final long[] jjtoToken = {
   0xfffffffffffffe01L, 0x0L, 
};
static final long[] jjtoSkip = {
   0x6L, 0x0L, 
};
protected SimpleCharStream input_stream;
private final int[] jjrounds = new int[42];
private final int[] jjstateSet = new int[84];
protected char curChar;
public AnalizadorSintacticoTiny1TokenManager(SimpleCharStream stream)
{
   if (SimpleCharStream.staticFlag)
      throw new Error("ERROR: Cannot use a static CharStream class with a non-static lexical analyzer.");
   input_stream = stream;
}
public AnalizadorSintacticoTiny1TokenManager(SimpleCharStream stream, int lexState)
{
   this(stream);
   SwitchTo(lexState);
}
public void ReInit(SimpleCharStream stream)
{
   jjmatchedPos = jjnewStateCnt = 0;
   curLexState = defaultLexState;
   input_stream = stream;
   ReInitRounds();
}
private final void ReInitRounds()
{
   int i;
   jjround = 0x80000001;
   for (i = 42; i-- > 0;)
      jjrounds[i] = 0x80000000;
}
public void ReInit(SimpleCharStream stream, int lexState)
{
   ReInit(stream);
   SwitchTo(lexState);
}
public void SwitchTo(int lexState)
{
   if (lexState >= 1 || lexState < 0)
      throw new TokenMgrError("Error: Ignoring invalid lexical state : " + lexState + ". State unchanged.", TokenMgrError.INVALID_LEXICAL_STATE);
   else
      curLexState = lexState;
}

protected Token jjFillToken()
{
   Token t = Token.newToken(jjmatchedKind);
   t.kind = jjmatchedKind;
   String im = jjstrLiteralImages[jjmatchedKind];
   t.image = (im == null) ? input_stream.GetImage() : im;
   t.beginLine = input_stream.getBeginLine();
   t.beginColumn = input_stream.getBeginColumn();
   t.endLine = input_stream.getEndLine();
   t.endColumn = input_stream.getEndColumn();
   return t;
}

int curLexState = 0;
int defaultLexState = 0;
int jjnewStateCnt;
int jjround;
int jjmatchedPos;
int jjmatchedKind;

public Token getNextToken() 
{
  int kind;
  Token specialToken = null;
  Token matchedToken;
  int curPos = 0;

  EOFLoop :
  for (;;)
  {   
   try   
   {     
      curChar = input_stream.BeginToken();
   }     
   catch(java.io.IOException e)
   {        
      jjmatchedKind = 0;
      matchedToken = jjFillToken();
      return matchedToken;
   }

   jjmatchedKind = 0x7fffffff;
   jjmatchedPos = 0;
   curPos = jjMoveStringLiteralDfa0_0();
   if (jjmatchedKind != 0x7fffffff)
   {
      if (jjmatchedPos + 1 < curPos)
         input_stream.backup(curPos - jjmatchedPos - 1);
      if ((jjtoToken[jjmatchedKind >> 6] & (1L << (jjmatchedKind & 077))) != 0L)
      {
         matchedToken = jjFillToken();
         return matchedToken;
      }
      else
      {
         continue EOFLoop;
      }
   }
   int error_line = input_stream.getEndLine();
   int error_column = input_stream.getEndColumn();
   String error_after = null;
   boolean EOFSeen = false;
   try { input_stream.readChar(); input_stream.backup(1); }
   catch (java.io.IOException e1) {
      EOFSeen = true;
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
      if (curChar == '\n' || curChar == '\r') {
         error_line++;
         error_column = 0;
      }
      else
         error_column++;
   }
   if (!EOFSeen) {
      input_stream.backup(1);
      error_after = curPos <= 1 ? "" : input_stream.GetImage();
   }
   throw new TokenMgrError(EOFSeen, curLexState, error_line, error_column, error_after, curChar, TokenMgrError.LEXICAL_ERROR);
  }
}

}
