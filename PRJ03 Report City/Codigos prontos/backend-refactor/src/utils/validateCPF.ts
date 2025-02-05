export function validateCpf(cpf: string): boolean {
    cpf = cpf.replace(/\D/g, '');
    
    if (cpf.length !== 11) return false;
    if (/^(\d)\1+$/.test(cpf)) return false;
  
    let sum = 0;
    for (let i = 0; i < 9; i++) {
      sum += parseInt(cpf.charAt(i)) * (10 - i);
    }
    let rest = sum % 11;
    const dv1 = rest < 2 ? 0 : 11 - rest;
  
    if (dv1 !== parseInt(cpf.charAt(9))) return false;
  
    sum = 0;
    for (let i = 0; i < 10; i++) {
      sum += parseInt(cpf.charAt(i)) * (11 - i);
    }
    rest = sum % 11;
    const dv2 = rest < 2 ? 0 : 11 - rest;
  
    return dv2 === parseInt(cpf.charAt(10));
  }